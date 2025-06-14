class TASK037
{
    private int pwd;
    protected int salary;
    public int empid;
    public void setPwd(int pwd)
    {
        this.pwd = pwd;
    }

    public int getPwd() {
        return pwd;

    }
}
class Hr extends TASK037
{
    Hr(){
        super.setPwd(1234);
        super.salary=50000;
        super.empid=10001;
    }
}
class driver
{
    public static void main(String[] args)
    {
        Hr h = new Hr();
        System.out.println(h.getPwd());
        System.out.println(h.salary);
        System.out.println(h.empid);
    }

}