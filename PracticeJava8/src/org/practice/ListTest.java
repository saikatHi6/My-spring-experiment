package org.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListTest {

	private static final String mutex = new String();

	public static void main(String[] args) {
		
		
		
		ListTest listT = new ListTest();
		listT.threadTest();
		
		// TODO Auto-generated method stub

		/*
		 * String[] dagApphostNames = { "EX16-M1-38-164.EX16AIT.COM",
		 * "EX-16-M2-38-165.EX16AIT.COM", "EX-16-M2-38-166.EX16AIT.COM" }; String
		 * passiveNodes = Arrays.stream(dagApphostNames) .filter((appHost) ->
		 * !appHost.equals("EX16-M1-38-164.EX16AIT.COM")) .filter((appHost) ->
		 * appHost.contains("EX16AIT")) //
		 * .map(String::substring(0,String,indexOf("."))) .map((appHostWithoutCom) ->
		 * appHostWithoutCom.substring(0, appHostWithoutCom.indexOf(".")))
		 * .collect(Collectors.joining(" "));
		 * 
		 * System.out.println("-----------" + passiveNodes);
		 * 
		 * List<Student> lStudents = new ArrayList<Student>(); lStudents.removeIf(s ->
		 * s.getAge() > 6); List<String> exchMountDismountDbList = new
		 * ArrayList<String>(); System.out.println(Math.abs(5 - 7));
		 * exchMountDismountDbList.add("s1"); exchMountDismountDbList.add("s2");
		 * exchMountDismountDbList.add("s3"); exchMountDismountDbList.add("s4");
		 * 
		 * System.out.println(exchMountDismountDbList.size());
		 * exchMountDismountDbList.forEach(System.out::println);
		 * 
		 * List<String> subList = new ArrayList<String>(
		 * exchMountDismountDbList.subList(0, exchMountDismountDbList.size() / 2));
		 * subList.forEach(System.out::println);
		 */
	}

	public void threadTest() {

		Map<String, List<String>> dbsWithHost = new HashMap<String, List<String>>();
		List<String> dbNames = new ArrayList<String>();
		dbNames.add("DB1");
		dbNames.add("DB2");
		dbNames.add("DB3");
		dbsWithHost.put("Node1", dbNames);
		List<String> dbNames2 = new ArrayList<String>();
		dbNames2.add("DB4");
		dbNames2.add("DB5");
		dbsWithHost.put("Node2", dbNames2);
		dbsWithHost.entrySet().parallelStream().forEach((entry) -> {
			entry.getValue().parallelStream().forEach((db) -> {
				execute(entry.getKey(), db);
			});
		});
	}

	public void execute(String Node, String db) {
		parrallelMethod1(Node, db);
		
		synchronized (mutex) {
			sequencial1(Node, db);
		}
		parrallelMethod2(Node, db);
	}

	public void parrallelMethod1(String Node, String db) {
		System.out.println(
				Thread.currentThread() + " parrallelMethod1 Command Executing for db " + db + " on node " + Node);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread() + " parrallelMethod1 Command Executing for db " + db + " on node "
				+ Node + " is Completed");
	}

	public void parrallelMethod2(String Node, String db) {
		System.out.println(
				Thread.currentThread() + " parrallelMethod2 Command Executing for db " + db + " on node " + Node);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread() + " parrallelMethod2 Command Executing for db " + db + " on node "
				+ Node + " is Completed");
	}

	public void sequencial1(String Node, String db) {
		System.out.println(Thread.currentThread() + " sequencial1 Command Executing for db " + db + " on node " + Node);
		
		for (int i=0;i<=20;i++) {
			System.out.println(Thread.currentThread() + " sequencial1 Command Executing for db " + db + " on node " + Node);

		}
		System.out.println(Thread.currentThread() + " sequencial1 Command Executing for db " + db + " on node " + Node
				+ " is Completed");
	}

}
