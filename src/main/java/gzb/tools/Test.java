package gzb.tools;

import gzb.db.script.entity.Script;

import java.util.Date;

public class Test {

	public static void main(String agrs[]) throws Exception {
		Script script=new Script();
		System.out.println(script.query("select * from Script where scriptId = ?", new String[]{"1"}));
		System.out.println(script.get("select * from Script where scriptId = ?", new String[]{"1"}).runState());
		System.out.println(script);
		long a=new Date().getTime();
		//script.save();
		/*for (int i=0;i<10000;i++){
			script.save();
		}*/
		long b=new Date().getTime();
//System.out.println(b-a);
	}

}