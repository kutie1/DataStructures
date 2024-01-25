public class Main {

    // show map

    static class Product {
        // ...
    }
    

    public static void main(String[] args) {
        String s = "Hello, World!";
        byte b = 127;
        // 0...255 – 255 day of the year is the programmers day
        Product p1 = new Product();             // 56 bytes
        var copy1 = p1;
        var copy2 = p1;
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        Product p5 = new Product();
        Product p6 = new Product();
        Product p7 = new Product();
        Product p8 = new Product();
        Product p9 = new Product();
        Product p10 = new Product();

        Product[] ps = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};

        // byte address is what data type?

        // 8 Gb = ??? bytes
        int address = System.identityHashCode(p1);
        String text = Integer.toHexString(address);
        System.out.println("0x" + text.toUpperCase());

        // 0b11111111

        System.out.println(Long.toHexString(Long.MAX_VALUE).toUpperCase());
    }
}
