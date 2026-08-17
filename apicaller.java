
public class App {

    static class PriceData {
        double price;
        String timestamp;

        PriceData(double price, String timestamp){
            this.price = price;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args){
        String apiKey = System.getenv("TWELVE_DATA_API_KEY");

        if(apiKey == null || apiKey.isEmpty()){
            System.out.println("API Key not found...");
        }

        String url = "https://api.twelvedata.com/price?symbol=DIA&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        Queue<PriceData> queue = new ConcurrentLinkedQueue<>();

        while(true){

            try {
                HttpRequest request = HttpRequest.newBuilder()
                                        .uri(URI.create(url))
                                        .GET()
                                        .build();
                
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String body = response.body();

                Pattern pattern = Pattern.compile("\"price\"\\s*:\\s*\"([0-9.]+)\"");
                Matcher matcher = pattern.matcher(price);

                if(matcher.find()){
                    double price = Double.parseDouble(matcher.group(1));
                    String timestamp = Instant.now().toString();
                    
                }
            }
        }
    }
}