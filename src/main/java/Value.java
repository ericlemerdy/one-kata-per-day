public enum Value {

    _2("2"), _3("3"), _4("4"), _5("5"), _6("6"), _7("7"), _8("8"), _9("9"), _10("10"), Jack("jack"), Queen("queen"), King("king"), Ace("ace");

    private String stringValue;

    Value(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
       return stringValue;
    }
}
