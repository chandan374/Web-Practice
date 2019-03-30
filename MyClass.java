import java.util.*;

class Student {
    
    public String name;   
    public double cgpa;
    public int token;
    
    public Student(String name, double cgpa, int token){
        this.name=name;
        this.cgpa=cgpa;
        this.token=token;
    }
    
    public String getName(){
        return this.name;
    }
}
class StudentComparator implements Comparator<Student>{
    
    public int compare(Student s1, Student s2){
        
        // comparision on basis of cgpa
        if(s1.cgpa<s2.cgpa){
            return 1;
        }else if(s1.cgpa>s2.cgpa){
            return -1;
        }else{
               // if cgpa of studet is equal then comparsion on basis of name
            if(s1.name.compareTo(s2.name)>0){
                return 1;
            }else if(s1.name.compareTo(s2.name)<0){
                return -1;
            }else{
                   // if both the name is same then comparsion on basis of token 
                if(s1.token>s2.token){
                    return 1;
                }else if(s1.token<s2.token){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }
}
public class MyClass{
    public static void main(String[] args) {
        
        // Scanner class object is created
        Scanner s=new Scanner(System.in);
        
        // declaring priority queue to store student in reguired order, comparator of pq is defined as according to problem
        PriorityQueue<Student> pq=new PriorityQueue<>(new StudentComparator());
        
       
        int n;
        
        // taking input from user number of operation to be performed
        n=s.nextInt();
        String check;
        String name;
        double cgpa;
        int token;  // token are unique in nature 
        while((n--)>0){
            check=s.next();
            
            // firest string is checked either it is ENTER OR SERVED
            if(check.charAt(0)=='E'){
                  
                // student detail is taken as input from user
                name=s.next();
                cgpa=s.nextDouble();
                token=s.nextInt();
                
                // student class, object is created 
                Student st = new Student(name,cgpa,token);
                pq.add(st);
                
            }
            else
            {
                // if entered string is SERVED, top of pq is printed, and Student is removed form pq
                
                if(pq.isEmpty())
                {
                   continue; 
                   
                }
                
                Student st2 = pq.remove();
            }
        }
        
        
        if(pq.isEmpty()){
            
            // as all student are served so a.t.p we print empty
            System.out.println("EMPTY");
            
        }
        else
        {
            while(!pq.isEmpty())
            {
                Student st2=pq.remove();
                System.out.println(st2.getName());   // .getName() method is used to get name of student
            }
        }
    }
}
