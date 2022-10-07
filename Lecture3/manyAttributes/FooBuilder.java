package manyAttributes;

public class FooBuilder {
    protected String arg1;
    protected Integer arg2;
    protected Double arg3;
    protected Boolean arg4;
    protected String arg5;
    
    public FooBuilder() {
        super();
    }

    public FooBuilder arg1(String arg1) {
        this.arg1 = arg1;
        return this;
    }

    public FooBuilder arg2(Integer arg2) {
        this.arg2 = arg2;
        return this;
    }

    public FooBuilder arg3(Double arg3) {
        this.arg3 = arg3;
        return this;
    }

    public FooBuilder arg4(Boolean arg4) {
        this.arg4 = arg4;
        return this;
    }

    public FooBuilder arg5(String arg5) {
        this.arg5 = arg5;
        return this;
    }

    public Foo build() {
        Foo f = null;
        f = new Foo(this);
        return f;
    }   
}
