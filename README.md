
# FilePackerUnpacker with Custom Key-Based ASCII Encryption And Decryption

A Java-based file archiving utility that packs multiple files into a single archive with custom encryption using ASCII value shifting.

## 🔐 Features

### Core Functionality
- **File Packing**: Combine multiple files from a directory into a single packed file
- **File Unpacking**: Extract individual files from a packed archive
- **Custom Encryption**: Uses user-provided keys with ASCII value shifting
- **Key Management**: Automatic key file generation and storage
- **Cross-Platform**: Works on any system with Java installed

### Encryption Details
- **Encryption Method**: Custom ASCII value shifting
- **Key-Based Security**: Each character in your key is used for encryption
- **Encryption Formula**: `encrypted_byte = data_byte + (key_character + 3)`
- **Decryption Formula**: `decrypted_byte = encrypted_byte - (key_character - 3)`
- **Key Cycling**: Key characters are cycled through for each byte of data

## 📁 Project Structure

```
FilePackerUnpacker/
├── MarvellousPackerUnpacker/
│   ├── MarvellousPacker.java      # Main packing class with encryption
│   ├── MarvellousUnpacker.java    # Main unpacking class with decryption
│   └── Main.java                  # User interface and menu system
├── a/                            # Sample directory for testing
│   ├── lb.txt
│   ├── ppa.txt
│   └── test.txt
└── README.md                     # This file
```

## 🚀 Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any text editor or IDE (Eclipse, IntelliJ IDEA, VS Code, etc.)

### Compilation
```bash
# Navigate to the project directory
cd FilePackerUnpacker

# Compile all Java files
javac MarvellousPackerUnpacker\*.java
```

## 💻 Usage

### Running the Application
```bash
# Run the main application
java MarvellousPackerUnpacker.Main
```

### Menu Options
1. **Pack Files (with encryption)** - Create encrypted archive
2. **Unpack Files (with decryption) - Manual key** - Extract with manual key input
3. **Unpack Files (with decryption) - Auto load from key file** - Extract using saved key
4. **Exit** - Close the application

### Example Usage

#### Packing Files
1. Run the application: `java MarvellousPackerUnpacker.Main`
2. Select option `1` (Pack Files)
3. Enter packed file name: `myarchive.pack`
4. Enter directory to pack: `a`
5. Enter encryption key: `omwakhare`

**Output:**
- Creates `myarchive.pack` (encrypted archive)
- Creates `myarchive.pack.key` (encrypted key file)

#### Unpacking Files (Manual Key)
1. Select option `2` (Unpack Files - Manual key)
2. Enter packed file name: `myarchive.pack`
3. Enter decryption key: `omwakhare`

#### Unpacking Files (Auto Key)
1. Select option `3` (Unpack Files - Auto load)
2. Enter packed file name: `myarchive.pack`
3. Key is automatically loaded from `myarchive.pack.key`

## 🔧 Technical Details

### Encryption Algorithm
```java
// For each byte of data:
char keyChar = encryptionKey.charAt(keyIndex % encryptionKey.length());
int encryptedByte = (data[i] + (keyChar + 3)) % 256;
```

### Key File Format
- **Storage**: Key is stored with +3 ASCII shift
- **Example**: Key "omwakhare" becomes "rpzdnkdkh" in key file
- **Security**: Key file contains encrypted version of original key

### File Format
- **Header**: 100-byte header for each file containing name and size
- **Data**: Encrypted file content using custom ASCII shifting
- **Structure**: Sequential files with headers

## 📊 Example Encryption Process

### Key: "omwakhare"
| Key Character | ASCII | +3 for Encryption | Used For |
|---------------|-------|-------------------|----------|
| o | 111 | 114 (r) | Byte 1, 10, 19, ... |
| m | 109 | 112 (p) | Byte 2, 11, 20, ... |
| w | 119 | 122 (z) | Byte 3, 12, 21, ... |
| a | 97 | 100 (d) | Byte 4, 13, 22, ... |
| k | 107 | 110 (n) | Byte 5, 14, 23, ... |
| h | 104 | 107 (k) | Byte 6, 15, 24, ... |
| a | 97 | 100 (d) | Byte 7, 16, 25, ... |
| r | 114 | 117 (u) | Byte 8, 17, 26, ... |
| e | 101 | 104 (h) | Byte 9, 18, 27, ... |

## 🐛 Debug Features

The application includes debug output to help understand the encryption process:
- **Key Information**: Shows received key and length
- **File Processing**: Displays file names and sizes being processed
- **Key Characters**: Shows each key character as it's used for encryption
- **Encryption Status**: Indicates when encryption is about to begin

## 📝 Code Structure

### MarvellousPacker.java
- **Purpose**: Handles file packing with encryption
- **Key Features**:
  - Directory traversal
  - File reading and encryption
  - Key file generation
  - Statistical reporting

### MarvellousUnpacker.java
- **Purpose**: Handles file unpacking with decryption
- **Key Features**:
  - Archive reading
  - Key file loading
  - Data decryption
  - File recreation

### Main.java
- **Purpose**: User interface and application flow
- **Key Features**:
  - Menu system
  - User input handling
  - Application coordination

## 🔒 Security Notes

- **Key Security**: Keep your encryption keys secure
- **Key Files**: The `.key` files contain encrypted versions of your keys
- **File Integrity**: Always verify that unpacked files match originals
- **Key Management**: Use the same key for packing and unpacking

## 🚨 Troubleshooting

### Common Issues
1. **"Key characters not printing"**: Ensure files have content (not empty)
2. **"Unable to create pack file"**: File already exists, delete it first
3. **"Key file not found"**: Use manual key option or ensure key file exists
4. **Compilation errors**: Ensure all files are in correct package structure

### Debug Mode
The application includes extensive debug output. Look for:
- `DEBUG: Encryption key received: [key]`
- `DEBUG: Key length: [number]`
- `DEBUG: About to encrypt [number] bytes of data`
- `key char is :[character]`

## 📈 Performance

- **Memory Efficient**: Uses 1024-byte buffers for file I/O
- **Sequential Processing**: Files are processed one at a time
- **Modular Arithmetic**: Ensures byte values stay within valid range (0-255)

## 🤝 Contributing

This is a custom implementation for educational purposes. Feel free to modify and enhance the code according to your needs.

## 📄 License

This project is for educational and personal use.

---

**Created by**: Vaibhav Gayake
**Version**: 1.0  
**Last Updated**: 2025

For questions or support, please refer to the code comments and debug output.
