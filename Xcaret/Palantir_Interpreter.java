import java.util.*;

@SuppressWarnings("serial")
class InvalidException extends Exception {
	public InvalidException(String msg) {
		super(msg);
	}
}

public class Interpreter {

	private static Stack<String> stack = null;
	private static Map<String, Integer> loopMap = null;
	private static List<String> inputs = null;
	
	private static final String PUSH = "PUSH";
	private static final String PRINT = "PRINT";
	private static final String ADD = "ADD";
	private static final String SUB = "SUB";
	private static final String MUL = "MUL";
	private static final String DIV = "DIV";
	private static final String LABEL = "LABEL";
	private static final String LOOP = "LOOP";
	private static final String GOTO = "GOTO";
	
	public static void main(String[] args) throws InvalidException {
		stack = new Stack<>();
		loopMap = new HashMap<>();
		
		inputs = new ArrayList<>();
		inputs.add("PUSH 1");
		inputs.add("PUSH 2");
		inputs.add("PUSH 3");
		inputs.add("LABEL LOOP");
		inputs.add("PUSH 4");
		inputs.add("PRINT");
		inputs.add("PUSH LOOP");
		inputs.add("GOTO");
		
		for (int i = 0; i < inputs.size(); i++) {
			executeInstruction(inputs.get(i), i);
		}
	}
	
	private static void executeInstruction(String line, int index) throws InvalidException {
		line = line.trim();
		String[] tokens = line.split(" ");
		String instruction = null;
		
		if (tokens.length == 0) {	/* Empty input */
			return;
		} else if (tokens.length == 1) { /* Only has one instruction token */
			instruction = tokens[0].trim();
			if (instruction.equals(ADD) || instruction.equals(SUB) || instruction.equals(MUL) || instruction.equals(DIV)) {
				doCalculation(instruction);
			} else if (instruction.equals(PRINT)) {
				doPrint();
			} else if (instruction.equals(GOTO)) {
				doGoto();
			} else {
				doInvalidInput("Invalid instruction");
			}	
		} else if (tokens.length == 2) { /* Hash two instruction tokens */
			instruction = tokens[0].trim();
			String variable = tokens[1].trim();
			
			if (instruction.equals(PUSH)) {
				doPush(variable, index);
			} else if (instruction.equals(LABEL) && variable.equals(LOOP)) {
				doLabel(index);
			} else {
				doInvalidInput("Invalid instruction");
			}
		} else {
			doInvalidInput("Invalid instruction");
		}
	}
	
	private static void doCalculation(String instruction) throws InvalidException {
		if (stack.size() <= 1) {
			doInvalidInput("Less than two elements in stack.");
		}
		
		int a = Integer.parseInt(stack.pop());
		int b = Integer.parseInt(stack.pop());
		int res = 0;
		
		switch(instruction) {
		case ADD:
			res = a + b;
			break;
		case SUB:
			res = b - a;
			break;
		case MUL:
			res = a * b;
			break;
		case DIV:
			if (a == 0) {
				doInvalidInput("Cannot divided by zero,");
			}
			res = b / a;
			break;
		default:
			break;
		}
		
		stack.push(Integer.toString(res));
	}
	
	private static void doPrint() {
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	private static void doGoto() throws InvalidException {
		if (!loopMap.containsKey("START") || !loopMap.containsKey("END")) {
			doInvalidInput("No LABEL LOOP before.");
		}	
		int start = loopMap.get("START");
		int end = loopMap.get("END");
	
		for (int i = start; i <= end; i++) {
			executeInstruction(inputs.get(i), i);
		}
	}
	
	private static void doPush(String variable, int index) throws InvalidException {
		if (variable.equals(LOOP)) {
			if (!loopMap.containsKey("START")) {
				doInvalidInput("No label before.");
			}
			loopMap.put("END", index);
		} else {
			for (int i = 0; i < variable.length(); i++) {
				if (variable.charAt(i) < '0' || variable.charAt(i) > '9') {
					doInvalidInput("Invalid push variable");
				}
			}
			stack.push(variable);
		}	
	}
	
	private static void doLabel(int index) {
		loopMap.put("START", index);
	}
	
	private static void doInvalidInput(String msg) throws InvalidException {
		throw new InvalidException(msg);
	}
}

