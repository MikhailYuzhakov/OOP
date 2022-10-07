package manyAttributes;

public class Program {
    public static void main(String[] args) {
        Foo f1 = new FooBuilder().arg1("arg1").arg2(123).arg3(12.34).arg4(false).arg5("arg5").build();
        System.out.println(f1.toString());

        Foo f2 = new FooBuilder().arg1("arg1").arg2(123).arg4(false).arg5("arg5").build();
        System.out.println(f2.toString());

        Foo f3 = new FooBuilder().arg1("arg1").arg2(123).arg3(12.34).arg4(false).build();
        System.out.println(f3.toString());

        Foo f4 = new FooBuilder().arg1("arg1").arg2(123).arg3(12.34).arg5("arg5").build();
        System.out.println(f4.toString());
    }
}
