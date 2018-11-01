import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FolderAndCows {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int Q = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        String[] MN = line.split("\\s");
        Map<Integer, Folder> folderMap = new HashMap<>();
        Set<Integer> cowList = new HashSet<>();
        Set<Integer> cowSet = null;
        Folder folder = null;
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);
        
        for(int i=0; i<M; i++){
            line = sc.nextLine();
            String[] MK = line.split("\\s");
            folder = new Folder();
            folder.fid = Integer.parseInt(MK[0]);
            cowSet = new HashSet<>();
            int K = Integer.parseInt(MK[1]);
            for(int j=0; j<K; j++){
                cowSet.add(Integer.parseInt(MK[j+2]));
                cowList.add(Integer.parseInt(MK[j+2]));
            }
            folder.cows = cowSet;
            folder.isShared = true;
            folderMap.put(folder.fid, folder);
            
        }
        
        for(int i=0; i<N; i++){
            line = sc.nextLine();
            String[] NK = line.split("\\s");
            folder = new Folder();
            folder.fid = Integer.parseInt(NK[0]);
            cowSet = new HashSet<>();
            int K = Integer.parseInt(NK[1]);
            for(int j=0; j<K; j++){
                cowSet.add(Integer.parseInt(NK[j+2]));
                cowList.add(Integer.parseInt(NK[j+2]));
            }
            folder.cows = cowSet;
            folder.isShared = false;
            folderMap.put(folder.fid, folder);
        }
        
        int G = Integer.parseInt(sc.nextLine());
        
        for(int i=0; i<G; i++){
            line = sc.nextLine();
            String[] UV = line.split("\\s");
            int U = Integer.parseInt(UV[0]);
            int V = Integer.parseInt(UV[1]);
            
            folderMap.get(U).sub.add(V);
        }
        
        sc.close();
        
        List<Integer> leaves = new ArrayList<>();
        for(Integer f: folderMap.keySet()) {
        	Folder fol = folderMap.get(f);
        	
        	if(fol.sub.isEmpty()) leaves.add(f);
        	else {
        		for(Integer s: fol.sub) {
            		Folder ch = folderMap.get(s);
            		if(ch.isShared) {
            			ch.cows.addAll(fol.cows);
            		}else {
            			continue;
            		}
            	}
        	}
        }
        Set<Integer> ans = new HashSet<>();
        for(Integer c: cowList) {
        	
        	for(Integer l: leaves) {
        		Folder fkey = folderMap.get(l);
        		if(!fkey.cows.contains(c)) ans.add(c);
        	}
        }
        int i=0;
        for(Integer a: ans) {
        	System.out.print(a);
        	i++;
        	if(i!= ans.size()) {
        		System.out.print(" ");
        	}
        }
    }    
    
}

class Folder{
    int fid;
    Set<Integer> cows;
    Set<Integer> sub = new HashSet<>();
    boolean isShared;

 }