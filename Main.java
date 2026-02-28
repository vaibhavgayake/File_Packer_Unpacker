package MarvellousPackerUnpacker;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sobj = new Scanner(System.in);
        int choice = 0;
        
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------- Marvellous Packer Unpacker --------------------------------");
        System.out.println("---------------------------- With Custom Key-Based ASCII Encryption -------------------------");
        System.out.println("--------------------------------------------------------------------------------------------");
        
        do
        {
            System.out.println("\nPlease select your choice:");
            System.out.println("1. Pack Files (with encryption)");
            System.out.println("2. Unpack Files (with decryption) - Manual key");
            System.out.println("3. Unpack Files (with decryption) - Auto load from key file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sobj.nextInt();
            
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter the name of packed file: ");
                    String packFileName = sobj.next();
                    
                    System.out.print("Enter the directory name to pack: ");
                    String dirName = sobj.next();
                    
                    System.out.print("Enter your encryption key: ");
                    String packKey = sobj.next();
                    
                    MarvellousPacker packer = new MarvellousPacker(packFileName, dirName, packKey);
                    packer.PackingActivity();
                    break;
                    
                case 2:
                    System.out.print("\nEnter the name of packed file to unpack: ");
                    String unpackFileName = sobj.next();
                    
                    System.out.print("Enter your decryption key: ");
                    String unpackKey = sobj.next();
                    
                    MarvellousUnpacker unpacker = new MarvellousUnpacker(unpackFileName, unpackKey);
                    unpacker.UnpackingActivity();
                    break;
                    
                case 3:
                    System.out.print("\nEnter the name of packed file to unpack: ");
                    String unpackFileName2 = sobj.next();
                    
                    MarvellousUnpacker unpacker2 = new MarvellousUnpacker(unpackFileName2);
                    unpacker2.UnpackingActivity();
                    break;
                    
                case 4:
                    System.out.println("\nThank you for using Marvellous Packer Unpacker!");
                    System.out.println("Goodbye!");
                    break;
                    
                default:
                    System.out.println("\nInvalid choice! Please select 1, 2, 3, or 4.");
                    break;
            }
        } while(choice != 4);
        
        sobj.close();
    }
}
