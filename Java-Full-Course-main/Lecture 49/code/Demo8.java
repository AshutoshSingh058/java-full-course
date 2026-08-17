public class Demo8 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(true) {
                System.out.println("Running...");
            }
        });

        t1.setDaemon(true);
        t1.start();

        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}

        return;
    }
}

/*

   Daemon Threads --> Background running threads
   --> Stop immediately once main thread is completed

   Threads --> User threads, Daemon threads

    Garbage collection --> Daemon thread
*/



#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;

    // pos[day][person] = position of that person on that day
    vector<vector<int>> pos(K, vector<int>(N + 1));

    for (int day = 0; day < K; day++) {
        for (int i = 0; i < N; i++) {
            int person;
            cin >> person;
            pos[day][person] = i;
        }
    }

    /*
        We use the order on day 1 as our base order.

        dp[i] = maximum size of a consistent group
               ending with the person at position i
               in day 1.
    */

    vector<int> order(N);

    for (int person = 1; person <= N; person++) {
        order[pos[0][person]] = person;
    }

    vector<int> dp(N, 1);

    int answer = 1;

    for (int i = 0; i < N; i++) {

        int currentPerson = order[i];

        for (int j = 0; j < i; j++) {

            int previousPerson = order[j];

            bool consistent = true;

            // previousPerson must come before currentPerson
            // on every day.
            for (int day = 0; day < K; day++) {
                if (pos[day][previousPerson] >=
                    pos[day][currentPerson]) {
                    consistent = false;
                    break;
                }
            }

            if (consistent) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }

        answer = max(answer, dp[i]);
    }

    cout << answer << '\n';

    return 0;
}