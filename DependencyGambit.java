import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *** input 
bloom-lib
23
lib-a 0
lib-b 1 lib-a
lib-c 1 lib-b
lib-d 1 lib-c
lib-e 0
lib-f 1 lib-e
lib-g 1 lib-e
lib-h 1 lib-e
lib-i 0
lib-j 1 lib-i
bloom-lib 7 lib-b lib-j lib-r lib-s lib-t lib-u lib-v
lib-k 0
lib-l 0
lib-m 0
lib-n 0
lib-o 0
lib-p 0
lib-q 0
lib-r 7 lib-k lib-l lib-m lib-n lib-o lib-p lib-q
lib-s 7 lib-k lib-l lib-m lib-n lib-o lib-p lib-q
lib-t 7 lib-k lib-l lib-m lib-n lib-o lib-p lib-q
lib-u 7 lib-k lib-l lib-m lib-n lib-o lib-p lib-q
lib-v 7 lib-k lib-l lib-m lib-n lib-o lib-p lib-q
output
lib-a lib-i lib-k lib-l lib-m lib-n lib-o lib-p lib-q lib-b lib-j lib-r lib-s lib-t lib-u lib-v bloom-lib
 * @author milan
 *
 */
public class DependencyGambit {

	static Map<String, List<String>> dependencyMap = new HashMap<>();
	static int recCount=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String line = in.nextLine();
		String chemical = line;
		int dependencySize = Integer.parseInt(in.nextLine());
		for(int i=0; i<dependencySize; i++){
			List<String> dependencyList = new ArrayList<>();
			line = in.nextLine();
			String [] lineArr = line.split(" ");
			String chemNameStr = lineArr[0];
			//String chemName = chemNameStr.split("-")[1];
			int dependencyCount = Integer.parseInt(lineArr[1]);
			for(int j=0; j<dependencyCount; j++){
				String dependentChem = lineArr[j+2];
				dependencyList.add(dependentChem);
			}
			dependencyMap.put(chemNameStr, dependencyList);
		}
		Node root = new Node();
		root.round = 0;
		root.name = chemical;
		root.childList = new ArrayList<>();
		//System.out.println(dependencyMap);
		List ansList = new ArrayList<Node>();
		createTree(root, ansList,1);
		printTree(root, ansList);
	}
	
	static Node createTree(Node root, List<Node> ansList, int round){
		List<String> dependencyList = dependencyMap.get(root.name);
		for(int i=0; i<dependencyList.size(); i++){
			Node child = new Node();
			child.name = dependencyList.get(i);
			if(ansList.contains(child))
				continue;
			child.childList = new ArrayList<>();
			child.round = round;
			root.childList.add(child);
			//System.out.println(child.name +" Added "+ round);
			round++;
			ansList.add(child);
			createTree(child, ansList, round);
			round--;
		}
		return root;
	}
	
	static void printTree(Node root, List<Node> ansList){
		List<Node> childList = root.childList;
		List<String> printList = new ArrayList<String>();
		printList.add(root.name);
		for(int i=0; i<ansList.size(); i++){
			Node child = ansList.get(i);
			int round = child.round;
			String name = round>=printList.size()?null:printList.get(round);
			if(name == null)
				printList.add(round, child.name);
			else{
				printList.set(round, name+" "+child.name);
			}
		}
		for(int i=printList.size()-1; i>0; i--){
			System.out.print(printList.get(i)+" ");
		}
		System.out.println(printList.get(0));
	}
}

class Node{
	int round;
	String name;
	List<Node> childList; 
	@Override
	public boolean equals(Object obj) {
		if( ((Node)obj).name.equals(name) )
			return true;
		else
			return false;
	}
}
