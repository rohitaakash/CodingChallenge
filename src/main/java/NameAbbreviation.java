
public class NameAbbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Walter Heisenberg White";
		System.out.println(answer(name));
	}
	
	public static String answer(String name) {
        String[] parts = name.split("\\s");
        StringBuilder answer = new StringBuilder();
        answer.append(parts[0]);
        if(parts.length == 2) {
            answer.append(" ").append(parts[1]);
            return answer.toString();
        }else{
            for(int i=1; i<parts.length-1; i++){
                answer.append(" "+parts[i].charAt(0)+".");
            }
        }
        answer.append(" ").append(parts[parts.length-1]);
        return answer.toString();
    }

}
