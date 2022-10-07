package manyAttributes;

public class Foo {
    private String arg1;
    private Integer arg2;
    private Double arg3;
    private Boolean arg4;
    private String arg5;
    
    public Foo(FooBuilder builder) {
        if (builder == null) {
            throw new IllegalArgumentException("Please provide employee builder to build employee object.");
        }

        this.arg1 = builder.arg1;
        this.arg2 = builder.arg2;
        this.arg3 = builder.arg3;
        this.arg4 = builder.arg4;
        this.arg5 = builder.arg5;
    }

    public String getArg1() {
        return arg1;
    }

    public Integer getArg2() {
        return arg2;
    }

    public Double getArg3() {
        return arg3;
    }

    public Boolean getArg4() {
        return arg4;
    }

    public String getArg5() {
        return arg5;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[arg1=").append(arg1).append(", arg2=").append(arg2).append(", arg3=")
                .append(arg3).append(", arg4=").append(arg4).append(", arg5=").append(arg5).append("]");
        return builder.toString();
    }
}
