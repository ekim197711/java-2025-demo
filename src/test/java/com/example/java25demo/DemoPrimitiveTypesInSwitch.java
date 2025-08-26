void main() {
    Object mikesVar = Integer.parseInt("20");
    Map<Object, Object> myMap = Map.of("name", "Mikes", "age", 20);
    String bloodtype = myMap.getOrDefault("bloodtype", "unknown").toString();
    IO.println(bloodtype);
    switch (mikesVar) {
        case int myInteger -> {
            IO.println("integer from switch " + myInteger);
        }
        case double myDouble -> {
            IO.println("double from switch " + myDouble);
        }
        case String myString -> {
            IO.println("String from switch " + myString);
        }
        default -> throw new IllegalStateException("Unexpected value: " + mikesVar);
    }
}