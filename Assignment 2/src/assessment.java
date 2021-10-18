public interface assessment {

    public void view();

    public boolean getstat();

    public void close(instructor i);
//closing an assignment can only be done by an instructor

    public boolean getopengradedstat(student a);
//submission can only be done by a student

    public void makesub(student a);

    public boolean getsubmittedstat(student a);

    public void viewsub(student s);

    public void maxmarks(instructor i);

    public void gradation(student s,int m,instructor i);

    public void getgradesinfo(student s);
}
