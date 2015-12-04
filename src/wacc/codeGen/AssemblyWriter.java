package wacc.codeGen;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import wacc.util.ProgramCode;

public class AssemblyWriter {
	
	private String fileName;
	
	public AssemblyWriter(String fileName) {
		this.fileName = fileName + ".s";
	}
	
	public void write() throws IOException {
		File output = new File(fileName);
		PrintStream outStream = new PrintStream(output);
		if (!output.exists()) {
			output.createNewFile();
		}
		String code = ProgramCode.getCode();
		outStream.print(code);
		outStream.close();
	}

}
