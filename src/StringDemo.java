public class StringDemo {
    public static void main(String args[]) {
        String s1 = "Hello";
        String s2 = new String(s1);
        String s3 = new String(s1);
        System.out.println(s1 + " equals " + s2 + "->" + s1.equals(s2));
        System.out.println(s1 + "==" + s2 + "->" + (s1 == s2));
        System.out.println(s2 + "==" + s3 + "->" + (s3 == s2));

        StringBuffer sb = new StringBuffer("Hello");

        System.out.println("buffer="+sb);
        System.out.println("length="+sb.length());
        System.out.println("capacity="+sb.capacity());

        Double d1=new Double(3.14324);
        Double d2=new Double("314324E-5");
        System.out.println(d1+" = " +d2+"->"+d1.equals(d2));
    }
}
