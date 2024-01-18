//Coustomized Database Management System

class node
{
    private static int Counter = 1;

    public int Rno;
    public String Name;
    public String City;
    public int Marks;

    public node next;

    public node(String B, String C, int D)
    {
        Rno = Counter;
        Counter++;

        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DBMS
{
    private node  first;

    public DBMS()
    {
        first = null;
        System.out.println("DBMS initialized Succeesfully..");
        System.out.println("Student table get created Successfully..");
    }

    public void InsertIntoTable(String Name, String City, int Marks)
    {
        node newn = new node(Name,City,Marks);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            node temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
        System.out.println("One record gets inserted succesfully...");
    }

    public void SelectStarFrom()
    {
        System.out.println("Data from student table is : ");

        node temp = first;

        System.out.println("---------------------------------------------------");
        while(temp != null)
        {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            temp = temp.next;
        }
        System.out.println("---------------------------------------------------");
    }

    public void SelectStarFromCity(String str)
    {
        System.out.println("Data from student table where city is : ");

        node temp = first;

        System.out.println("---------------------------------------------------");
        while(temp != null)
        {
            if(str.equals(temp.City))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
        System.out.println("---------------------------------------------------");
    }

    public void SelectCount()
    {
        node temp = first;
        int iCnt = 0;
        while(temp != null)
        {
            temp = temp.next;
            iCnt++;
        }
        System.out.println("Number of records in table "+iCnt);
    }

    public void SelectSum()
    {
        node temp = first;
        int iSum = 0;
        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
        }
        
        System.out.println("Sum is "+iSum);
    }

    public void SelectAvg()
    {
        node temp = first;
        int iSum = 0;
        int iCnt = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
            iCnt++;
        }
        
        System.out.println("Sum is "+(float)((float)iSum / (float)iCnt));
    }

    public void MaxMarks()
    {
        node temp = first;
        int iMax = 0;

        if(temp != null)
        {
            iMax = temp.Marks;
        }

        while(temp.next != null)
        {
            if(temp.Marks > iMax)
            {
                iMax = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("Max is "+iMax);
    }

    public void MinMarks()
    {
        node temp = first;
        int iMin = 0;

        if(temp != null)
        {
            iMin = temp.Marks;
        }

        while(temp != null)
        {
            if(temp.Marks < iMin)
            {
                iMin = temp.Marks;
            }
            temp = temp.next;
        }
        System.out.println("Min is "+iMin);
    }

    public void SelectStarFromName(String str)
    {
        node temp = first;

        System.out.println("Information of all Student with the name : "+str);
        while(temp != null)
        {
            if(str.equals(temp.Name))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
    }
    public void UpdateCity(int no, String str)
    {
        node temp = first;
        while(temp != null)
        {
            if(temp.Rno == no)
            {
                temp.City = str;
                break;
            }
            temp = temp.next;
        }
        System.out.println("Record gets updated...");
    }

    public void DeleteFrom(int no)
    {
        node temp = first;

        if(temp == null)
        {
            return;
        }

        if(temp.Rno == no)
        {
            first = first.next;
            return;
        }

        while(temp.next != null)
        {
            if(temp.next.Rno == no)
            {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}

class Program418
{
    public static void main(String Arg[])
    {
        DBMS obj = new DBMS();

        obj.InsertIntoTable("Amit","Pune",89);
        obj.InsertIntoTable("Pooja","Mumbai",95);
        obj.InsertIntoTable("Gauri","Pune",90);
        obj.InsertIntoTable("Amit","Nagar",81);
        obj.InsertIntoTable("Rahul","Satara",80);
        obj.InsertIntoTable("Neha","Pune",78);

        obj.SelectStarFrom();

        obj.SelectStarFromCity("Pune");

        obj.SelectCount();

        obj.SelectSum();

        obj.SelectAvg();

        obj.MaxMarks();

        obj.MinMarks();

        obj.SelectStarFromName("Amit");

        obj.UpdateCity(3,"Nashik");
        obj.SelectStarFrom();

        obj.DeleteFrom(5);
        obj.SelectStarFrom();

        obj.InsertIntoTable("Rukmini","Kolhapur",77);
        obj.SelectStarFrom();
    }
}

/*

Supported Queries

1: insert into student values('Amit','Punr',78);
2: select * from student;
3: select * from student where City = 'Pune';
4: select Count(Marks) from student;
5:Select(Sum) from student;
6: Select(Avg) from student;
7: Select(Max) from student;
8: Select(Min) from student;
9: Select * from student where name = "--------";
10: update student set City = "------"where Rno = _____;
11: delete from student where Rno = _____;

*/
