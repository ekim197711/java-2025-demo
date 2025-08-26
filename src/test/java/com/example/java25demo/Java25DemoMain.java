import static java.lang.IO.println;

void main() {
    println("test 123 hello world");
    StableValue<String> myStableString = StableValue.<String>of();
    println(myStableString.isSet());
    myStableString.trySet("hello");
    println(myStableString.isSet());
    myStableString.trySet("Something else");
    println(myStableString);
}

