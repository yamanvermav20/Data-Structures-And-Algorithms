// import java.io.*;
// public class classmein {
//     public static void main(String[] args){
//         try{
//             FileOutputStream fileOutputStream=new FileOutputStream("C:/data/demo.txt");
//             String data="Hello how are you?";
//             fileOutputStream.write(data.getBytes());
//             fileOutputStream.close();
//             FileInputStream fileInputStream=new FileInputStream("C:/data/demo.txt");
//             int i;
//             while((i=fileInputStream.read())!=-1){
//                 System.out.print((char) i);
//             }
//             fileInputStream.close();
            
//         }
//         catch (Exception exception){
//             System.out.print(exception);
//         }
//     }
// }

// import java.io.*;
// public class classmein {
//     public static void main(String[] args){
//         try{
//             BufferedOutputStream outputStream=new BufferedOutputStream(new FileOoutputStream("C:/data/"));
//             String data="This is my file data";
//             outputStream.write(data.getBytes());
//             outputStream.flush();
//         }
//         catch (Exception exception){
//             System.out.print(exception);
//         }
//     }
// }



import java.io.*;
public class classmein {
    public static void main(String[] args){
        try{
            BufferedOutputStream outputStream=new BufferedOutputStream(new FileOoutputStream("C:/data/"));
            String data="This is my file data";
            outputStream.write(data.getBytes());
            outputStream.flush();

            BufferedInputStream inputStream=new BufferedInputStream(new FileInputStream("C:/data"));
            int i;
            while((i=inputStream.read())!=-1){
                System.out.print((char)i);

            }
            inputStream.close();
        }
        catch (Exception exception){
            System.out.print(exception);
        }
    }
}