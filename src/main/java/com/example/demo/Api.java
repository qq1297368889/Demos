package com.example.demo;
import gzb.db.script.entity.Script;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Api {

    @RequestMapping("/test")
    public String test() {
        try {

            System.out.println(new Script().setScriptId(1).query());
            long a=new Date().getTime();
            //script.save();
		/*for (int i=0;i<10000;i++){
			script.save();
		}*/
            long b=new Date().getTime();
            System.out.println(b-a);


            return new Script().query(1,100).toJson("查询完成");
        } catch (Exception e) {

        }
        return "";
    }


}
