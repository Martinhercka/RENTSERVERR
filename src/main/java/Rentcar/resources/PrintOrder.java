package Rentcar.resources;

public class PrintOrder
{
    private String fname;
    private String lname;
    private String picktime;
    private String delitime;
    private String pickdate;
    private String delidate;
    private String pplace;
    private String deplace;
    private String mail;
    private String cnum;
    private String car;
    private String idcn;
    private String notes;


    public PrintOrder( String fname, String lname, String picktime,String delitime,String pickdate,String delidate,String pplace,String deplace,String mail,String cnum,String car,String idcn,String notes)
    {
        this.fname = fname;
        this.lname = lname;
        this.picktime = picktime;
        this.delitime = delitime;
        this.pickdate = pickdate;
        this.delidate = delidate;
        this.pplace = pplace;
        this.deplace = deplace;
        this.mail = mail;
        this.cnum = cnum;
        this.car = car;
        this.idcn = idcn;
        this.notes = notes;


    }



    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPicktime() {
        return picktime;
    }

    public String getDelitime() {
        return delitime;
    }

    public String getPickdate() {
        return pickdate;
    }

    public String getDelidate() {
        return delidate;
    }

    public String getPplace() {
        return pplace;
    }

    public String getDeplace() {
        return deplace;
    }

    public String getMail() {
        return mail;
    }

    public String getCnum() {
        return cnum;
    }

    public String getCar() {
        return car;
    }

    public String getIdcn() {
        return idcn;
    }

    public String getNotes() {
        return notes;
    }
}
