import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username ="root";
    private static final String password = "Admin@#1234";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String query ="INSERT INTO students(name,age,marks) VALUES(?,?,?)";
                        //for batch processing using statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Scanner scanner =new Scanner(System.in);
            while(true){
                System.out.println("enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter age: ");
                int age = scanner.nextInt();
                System.out.println("Enter marks: ");
                double marks = scanner.nextDouble();
                System.out.println("Enter more data (Y/N) : ");
                String choice = scanner.next();
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,age);
                preparedStatement.setDouble(3,marks);

                preparedStatement.addBatch();
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }

            int[] rowsAffected = preparedStatement.executeBatch();




//            //for batch processing using statement
//            Statement statement = connection.createStatement();
//            Scanner scanner =new Scanner(System.in);
//            while(true){
//                System.out.println("enter name: ");
//                String name = scanner.next();
//                System.out.println("Enter age: ");
//                int age = scanner.nextInt();
//                System.out.println("Enter marks: ");
//                double marks = scanner.nextDouble();
//                System.out.println("Enter more data (Y/N) : ");
//                String choice = scanner.next();
//                String query = String.format("INSERT INTO students(name,age,marks) VALUES('%s','%d','%f')",name,age,marks);
//                statement.addBatch(query);
//                if(choice.toUpperCase().equals("N")){
//                    break;
//                }
//            }
//
//            int[] rowsAffected = statement.executeBatch();
//            for(int i=0;i<rowsAffected.length;i++){
//                System.out.println(rowsAffected[i]);
//            }

//            //data retrive using preparedstatement
//            String query = "SELECT marks FROM students WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,3);
//            ResultSet resultSet =  preparedStatement.executeQuery();
//            if(resultSet.next()){
//                System.out.println(resultSet.getDouble("marks"));
//            }else{
//                System.out.println("data not listed");
//            }

 //           //data updation using prepared statements
//            String query = "INSERT INTO students(name,age,marks) VALUES(?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1,"Shailja");
//            preparedStatement.setInt(2,20);
//            preparedStatement.setDouble(3,98.9);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if(rowsAffected>0){
//                System.out.println("values updated");
//            }else{
//                System.out.println("values not updated");
//            }

//            //use of statement which leads to use connection and data manipulation ,retrivation
//            Statement statement = connection.createStatement();
//            //data deletion
//            String query = "DELETE FROM students WHERE id =2";
//            int rowsAffected = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data Deleted  Successfully!");
//            }else{
//                System.out.println("Data not Deleted ");
//            }
//
//            //data updation
//            String query = String.format("UPDATE students SET marks = %f WHERE id = %d",89.5,2);
//            int rowsAffected = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data UPdated  Successfully!");
//            }else{
//                System.out.println("Data not UPDATED");
//            }




//            // data insertion
//            String query = String.format("INSERT INTO students(name,age,marks) VALUES('%s',%d,%f)","Rahul",22,74.5);
//
//            int rowsAffected = statement.executeUpdate(query);
//            if(rowsAffected>0){
//                System.out.println("Data Inserted Successfully!");
//            }else{
//                System.out.println("Data not Inserted");
//            }


//            //---------------to print the table --------------------------
//            String query = "select * from students";
//            ResultSet resultSet = statement.executeQuery(query);
//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age =resultSet.getInt("age");
//                double marks = resultSet.getDouble("marks");
//                System.out.println("ID : "+id);
//                System.out.println("Name : "+ name);
//                System.out.println("Age : "+ age);
//                System.out.println("Marks : "+ marks);
//            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}