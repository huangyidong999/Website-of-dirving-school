package readAndwriteBy10;

import java.io.*;
import TextFileTest.Employee;

public class ReadWrite10 {
	/**
	 * java二进制形式写出数据
	 */
	public void wirteBinary() {  
        try {  
        	// 这里从外层到内层介绍 先应用文件写出类 来打开data.dat文件  然后应用高速缓冲输出流来过滤文件 
        	// 然后再以二进制写出类来打开缓冲类打开的内容  然后调用他的对象（os）来写出各种数据
            DataOutputStream os = new DataOutputStream(  
                    new BufferedOutputStream(new FileOutputStream(  
                            "E:\\data.dat")));  
            os.writeInt(1001);  
            os.writeByte(520);  
            os.writeBoolean(true);  
            os.writeFloat(10.0f);  
            os.writeLong(100l);  
            os.writeUTF("读写二进制文件");  
              
            os.flush();  
            os.close();  
              
        } catch (IOException e) {  
  
        }  
    }  
	/**
	 * java以二进制形式读入数据
	 */
	public void readBinary() {  
        try {  
        	// 首先还是用FileInputStream类来打开data.dat文件 然后用高速缓冲类来承接打开的文件
        	// 然后以二进制形式 读入 打开的缓冲区文件数据 称作对象(is) 然后调用is来读取各种数据
            DataInputStream is = new DataInputStream(  
                    new BufferedInputStream(new FileInputStream(  
                            "E:\\data.dat")));  
            System.out.println(is.readInt());  
            System.out.println(is.readByte());  
            System.out.println(is.readBoolean());  
            System.out.println(is.readFloat());  
            System.out.println(is.readLong());  
            System.out.println(is.readUTF());  
              
            is.close();  
        } catch (IOException e) {  
  
        }  
    }  
}
