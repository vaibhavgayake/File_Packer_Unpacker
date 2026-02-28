package MarvellousPackerUnpacker;

import java.util.*;
import java.io.*;

public class MarvellousPacker
{
    private String PackName;
    private String DirName;
    private String encryptionKey;

    public MarvellousPacker(String A, String B, String key)             // parameterized Constructor
    {
        this.PackName = A;
        this.DirName = B;
        this.encryptionKey = key;
    }
    
    private byte[] encryptData(byte[] data)
    {
        try
        {
            byte[] encryptedData = new byte[data.length];
            int keyIndex = 0;
            
            for(int i = 0; i < data.length; i++)
            {
                // Get the current character from the key (cycling through the key)
                char keyChar = encryptionKey.charAt(keyIndex % encryptionKey.length());
                
                System.out.println("key char is :"+keyChar);
                
                // Apply encryption: data byte + (key character + 3)
                int encryptedByte = (data[i] + (keyChar + 3)) % 256;
                encryptedData[i] = (byte)encryptedByte;
                
                keyIndex++;
            }
            
            return encryptedData;
        }
        catch(Exception e)
        {
            System.out.println("Error encrypting data: " + e.getMessage());
            return data; // Return original data if encryption fails
        }
    }
    
    private void saveEncryptionKey()
    {
        try
        {
            File keyFile = new File(PackName + ".key");
            FileWriter writer = new FileWriter(keyFile);
            
            // Store the key with +3 ASCII shift
            String encryptedKey = "";
            for(int i = 0; i < encryptionKey.length(); i++)
            {
                char originalChar = encryptionKey.charAt(i);
                char shiftedChar = (char)(originalChar + 3);
                encryptedKey += shiftedChar;
            }
            
            writer.write(encryptedKey);
            writer.close();
            System.out.println("Encryption key saved to: " + PackName + ".key (in +3 ASCII format)");
        }
        catch(Exception e)
        {
            System.out.println("Error saving encryption key: " + e.getMessage());
        }
    }

    public void PackingActivity()
    {
        try
        {
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------- Marvellous Packer Unpacker --------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------- Packing Activity ------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------");
            
            System.out.println("DEBUG: Encryption key received: " + encryptionKey);
            System.out.println("DEBUG: Key length: " + encryptionKey.length());

            int i = 0, j = 0, iRet = 0, iCountFile = 0;

            File fobj = new File(DirName);


            // Check the existance of Directory
            if(fobj.exists() && fobj.isDirectory())
            {
                System.out.println(DirName + " is successfully opened ...");

                File Packobj = new File(PackName);
            
                // Create a packed file
                boolean bRet = Packobj.createNewFile();

                if(bRet == false)
                {
                    System.out.println("Unable to create pack file...");
                    
                    return;
                }

                System.out.println("Packed file gets successfully created with name :" + PackName);

                // Retrieve all files from directory
                File Arr[] = fobj.listFiles();
                

                // Packed file object
                FileOutputStream foobj = new FileOutputStream(Packobj);

                // Buffer for read and write activity
                byte Buffer[] = new byte[1024];                        // mug tayar kela
                
                
                String Header = null;

                // Directory traversal
                for(i = 0; i < Arr.length; i++)
                {
                    Header =  Arr[i].getName() +" "+ Arr[i].length();       // added a space here by " "
                    
                    // Loop to form 100 bytes of header
                    for(j = Header.length(); j < 100; j++)
                    {
                        Header = Header + " ";
                    }

                    // write Header into packed file
                    foobj.write(Header.getBytes());                 // converted to string byte
                    
                    // Open file from directory  for reading
                    FileInputStream fiobj = new FileInputStream(Arr[i]);
                    
                    // write contents of file into packed file (i.e nili pishvi)
                    while ((iRet = fiobj.read(Buffer)) != -1) 
                    {
                        System.out.println("File Name Scanned :"+Arr[i].getName());
                        System.out.println("File Size read is :"+Arr[i].length());
                        System.out.println("DEBUG: About to encrypt " + iRet + " bytes of data");
                        
                        // Encrypt the data before writing
                        byte[] encryptedData = encryptData(Arrays.copyOf(Buffer, iRet));
                        foobj.write(encryptedData);
                    }

                    fiobj.close();
                    iCountFile++;
                }

                // Save encryption key
                saveEncryptionKey();
                
                System.out.println("Packing Activity Done...");

                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("----------------------------------- Statistical Report -------------------------------------");
                System.out.println("--------------------------------------------------------------------------------------------");

                // To be add
                System.out.println("Total files packed : " + iCountFile);
                System.out.println("All files have been encrypted using custom key-based ASCII shifting");

                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("---------------------------- Thank You For Using Our Application ---------------------------");
                System.out.println("--------------------------------------------------------------------------------------------");
            }
            else
            {
                System.out.println("There no such Directory...");
            }

        }    // End of try

        catch(Exception eobj)
        {}

    } // End of PackingActivity function

}  // End of MarvellousPacker class