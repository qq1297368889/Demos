package gzb.db;
import gzb.tools.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List;
public class AutuCode {
	static String dbName;
	public static void main(String[] args) throws Exception { 
		 dbName="script";
		List<mapInfo> list = getMapInfo();
		//autoAminPage(list); 
		for (mapInfo mapinfo : list) {  
			String code="";
			code+="package gzb.db."+dbName+".entity;\r\n";
			code+="import java.sql.Connection;\r\n";
			code+="import java.sql.PreparedStatement;\r\n";
			code+="import java.sql.ResultSet;\r\n";
			code+="import java.sql.SQLException;\r\n";
			code+="import java.util.ArrayList;\r\n";
			code+="import java.util.List;\r\n";
			code+="import java.util.Date;\r\n";
			code+="import gzb.db.DataBase;\r\n";
			code+="import gzb.tools.Log;\r\n";
			code+="import gzb.tools.TextTool;\r\n";  

			code+="public class "+capStr(mapinfo.name)+" {\r\n";
			String code_query_fenye="";
			String code_getset="";
			String code_para="";
			String code_gouzao1="\tpublic "+capStr(mapinfo.name)+"("; 
			String code_gouzao1_1="";
			String code_gouzao1_2="";
			String code_toConfig="\tpublic String toConfig(){\r\n"
					+ "\t\tString res=\"\";\r\n"; 
			String code_gouzao2="\tpublic "+capStr(mapinfo.name)+"(String json){\n" +
					"\t\tString temp;\n" +
					"\t\tif(json!=null && json.length()>0){\n" ;


			String code_toString="\t@Override\r\n"
					+ "\tpublic String toString(){\r\n" 
					+ "\t\tString res=\"{\"+\r\n"; 
			String code_query="\tpublic List<"+capStr(mapinfo.name)+"> query(String sql,Object []para) throws SQLException{\n" +
					"\t\tif(para==null){\n" +
					"\t\t\tpara=new Object[]{};\n" +
					"\t\t}\n" +
					"\t\tList<"+capStr(mapinfo.name)+"> list =null;\n" +
					"\t\t"+capStr(mapinfo.name)+" en=null;\n" +
					"\t\tConnection conn=null;  \n" +
					"\t\tResultSet rs=null;\n" +
					"\t\tPreparedStatement pstate=null; \n" +
					"\t\tStringBuilder sb=new StringBuilder(); \n" +
					"\t\tsb.append(\""+capStr(mapinfo.name)+".query:\").append(sql).append(\";参数:\"); \n" + 
					"\t\ttry {\n" +
					"\t\t\tlist=new ArrayList<"+capStr(mapinfo.name)+">();\n" +
					"\t\t\tconn = DataBase.getConnection();\n" +
					"\t\t\tpstate = conn.prepareStatement(sql); \n" +
					"\t\t\tString temp=\"\";\n" +
					"\t\t\tfor (int i = 0; i < para.length; i++) {\n" +
					"\t\t\t\tsb.append(para[i]).append(\",\");\n" +
					"\t\t\t\tpstate.setObject(i+1,para[i]); \n" +
					"\t\t\t}\n" +
					"\t\t\tlong t1=new Date().getTime();\n" +
					"\t\t\trs=pstate.executeQuery();\n" +
					"\t\t\tlong t2=new Date().getTime();\n" +  
					"\t\t\tsb.append(\";耗时:\");\n" +
					"\t\t\tsb.append(t2-t1);\n" +
					"\t\t\tsb.append(\"毫秒\");\n" +
					"\t\t\tLog.i(sb.toString());\n" +
					"\t\t\twhile (rs.next()) {  \n";
			code_query+="\t\t\t\ten=new "+capStr(mapinfo.name)+"();\n" ;
			String code_query_wu="";
			String code_query_wu_1="";
			String code_get_wu="";
			String code_get_wu_1="";


			String code_get="\tpublic "+capStr(mapinfo.name)+" get(String sql,Object []para) throws SQLException{\n" +  
					"\t\tif(para==null){\n" +
					"\t\t\tpara=new Object[]{};\n" +
					"\t\t}\n" +
					"\t\tConnection conn=null;  \n" +
					"\t\tResultSet rs=null;\n" +
					"\t\tPreparedStatement pstate=null; \n" +
					"\t\tStringBuilder sb=new StringBuilder(); \n" +
					"\t\tsb.append(\""+capStr(mapinfo.name)+".get:\").append(sql).append(\";参数:\"); \n" + 
					"\t\ttry {\n" + 
					"\t\t\tconn = DataBase.getConnection();\n" +
					"\t\t\tpstate = conn.prepareStatement(sql); \n" +
					"\t\t\tString temp=\"\";\n" +
					"\t\t\tfor (int i = 0; i < para.length; i++) {\n" +
					"\t\t\t\tsb.append(para[i]).append(\",\");\n" +
					"\t\t\t\tpstate.setObject(i+1,para[i]); \n" +
					"\t\t\t}\n" +
					"\t\t\tlong t1=new Date().getTime();\n" +
					"\t\t\trs=pstate.executeQuery();\n" +
					"\t\t\tlong t2=new Date().getTime();\n" +
					"\t\t\tsb.append(\";耗时:\");\n" +
					"\t\t\tsb.append(t2-t1);\n" +
					"\t\t\tsb.append(\"毫秒\");\n" +
					"\t\t\tLog.i(sb.toString());\n" +
					"\t\t\trs.last();\n"+
					"\t\t\tif(rs.getRow()==1){\n"+ 
					"\t\t\t\tthis.runState=true;\n"+
					"\t\t\t\trs.beforeFirst();\n"+
					"\t\t\t\trs.next();\n"; 
			String code_delete= "\tpublic int delete() throws Exception{\n" +
					"\t\tConnection conn=null;  \n" +
					"\t\tResultSet rs=null;\n" +
					"\t\tPreparedStatement pstate=null; \n" +
					"\t\tString sql=\"delete from "+mapinfo.name+" where "+mapinfo.id+"=?\";\n" +
					"\t\tStringBuilder sb=new StringBuilder(); \n" +
					"\t\tsb.append(\""+capStr(mapinfo.name)+".delete:\").append(sql).append(\";参数:\").append(this.toString()); \n" + 
				 
					"\t\ttry { \n" +
					"\t\t\tconn = DataBase.getConnection();\n" +
					"\t\t\tpstate = conn.prepareStatement(sql); \n" +
					"\t\t\tpstate.setObject(1,get"+capStr(mapinfo.id)+"()); \n" +
					"\t\t\tlong t1=new Date().getTime();\n"+
					"\t\t\tint res=pstate.executeUpdate();\n"+
					"\t\t\tlong t2=new Date().getTime();\n"+
					"\t\t\tsb.append(\";耗时:\");\n" +
					"\t\t\tsb.append(t2-t1);\n" +
					"\t\t\tsb.append(\"毫秒\");\n" +
					"\t\t\tLog.i(sb.toString());\n" +
					"\t\t\treturn res;\n" +
					"\t\t} catch (Exception e) {\n" +
					"\t\t\tLog.e(e,\"sql:\"+sql);\n" +
					"\t\t\tthrow e;\n" +
					"\t\t}finally{\n" +
					"\t\t\tDataBase.close(conn,rs,pstate);\n" +
					"\t\t} \n" + 
					"\t}\r\n";







			String code_save_1="";
			String code_save_2="";
			String code_update_1="";
			String code_update_2="";
			String code_save_3="";
			for (int i = 0; i < mapinfo.subName.size(); i++) {

				code_query_fenye="\tpublic gzb.tools.ListPage query(int page,int size) throws SQLException{\n" +
						"\t\tList<"+capStr(mapinfo.name)+"> list_ret=new ArrayList<"+capStr(mapinfo.name)+">();\n" +
						"\t\tList<"+capStr(mapinfo.name)+"> list=query(); \n" +
						"\t\t for (int i=(page-1)*size;i < list.size(); i++) {\n" +
						"\t\t\t list_ret.add(list.get(i));\n" +
						"\t\t\t if(list_ret.size()== size){\n" +
						"\t\t\t\t break;\n" +
						"\t\t\t }\n" +
						"\t\t}\n" +
						"\t\t gzb.tools.ListPage lp=new gzb.tools.ListPage();\n" +
						"\t\t lp.setCount(list.size());\n" +
						"\t\t lp.setLimit(size);\n" +
						"\t\t lp.setList(list_ret);\n" +
						"\t\t lp.setPage(page);\n" +
						"\t\t return lp;\n" + 
						"\t}\n";

				code_save_3+=mapinfo.subName.get(i)+",";
				code_getset+="\tpublic "+capStr(mapinfo.name)+" set"+capStr(mapinfo.subName.get(i))+"("+mapinfo.subType.get(i)+" "+mapinfo.subName.get(i)+") {\r\n";
				code_getset+="\t\tthis."+mapinfo.subName.get(i)+" = "+mapinfo.subName.get(i)+";\r\n";
				code_getset+="\t\treturn this;\r\n";
				code_getset+="\t}\r\n";


				code_getset+="\tpublic "+mapinfo.subType.get(i)+" get"+capStr(mapinfo.subName.get(i))+"() {\r\n";
				code_getset+="\t\treturn "+mapinfo.subName.get(i)+";\r\n"; 
				code_getset+="\t}\r\n";
				if("java.lang.String".equals(mapinfo.subType.get(i))){
					code_getset+="\tpublic "+capStr(mapinfo.name)+" MD5"+capStr(mapinfo.subName.get(i))+"() throws Exception{ \r\n";
					code_getset+="\t\tthis."+mapinfo.subName.get(i)+" = TextTool.textToMd5(this."+mapinfo.subName.get(i)+");\r\n"; 
					code_getset+="\t\treturn this;\r\n"; 
					code_getset+="\t}\r\n";

					code_getset+="\tpublic "+capStr(mapinfo.name)+" MD5"+capStr(mapinfo.subName.get(i))+"(String iv) throws Exception{ \r\n";
					code_getset+="\t\tthis."+mapinfo.subName.get(i)+" = TextTool.textToMd5(this."+mapinfo.subName.get(i)+"+iv);\r\n"; 
					code_getset+="\t\treturn this;\r\n"; 
					code_getset+="\t}\r\n";

					code_getset+="\tpublic "+capStr(mapinfo.name)+" AES"+capStr(mapinfo.subName.get(i))+"(String pwd,String iv) throws Exception{ \r\n";
					code_getset+="\t\tthis."+mapinfo.subName.get(i)+" = TextTool.textAESEncoder(this."+mapinfo.subName.get(i)+", pwd, iv);\r\n"; 
					code_getset+="\t\treturn this;\r\n"; 
					code_getset+="\t}\r\n";
				}

				code_query_wu_1+="\t\tif(get"+capStr(mapinfo.subName.get(i))+"() != null){\n" +
						"\t\t\tsql+=\""+mapinfo.subName.get(i)+" = ? and \";\n" +
						"\t\t\tpara.add(get"+capStr(mapinfo.subName.get(i))+"());\n" +
						"\t\t}\n";

				code_get_wu_1+="\t\tif(get"+capStr(mapinfo.subName.get(i))+"() != null){\n" +
						"\t\t\tsql+=\""+mapinfo.subName.get(i)+" = ? and \";\n" +
						"\t\t\tpara.add(get"+capStr(mapinfo.subName.get(i))+"());\n" +
						"\t\t}\n";

				code_para+="\tprivate "+mapinfo.subType.get(i)+" "+mapinfo.subName.get(i)+";\r\n";
				code_gouzao1_2+=mapinfo.subType.get(i)+" "+mapinfo.subName.get(i)+", ";
				code_gouzao1_1+="\t\tthis."+mapinfo.subName.get(i)+"="+mapinfo.subName.get(i)+";\r\n";

				code_gouzao2+="\t\t\ttemp = TextTool.JsonGetVal(json, \""+mapinfo.subName.get(i)+"\");\n" +
						"\t\t\tset"+capStr(mapinfo.subName.get(i))+"(temp==null || temp.length()==0 ? null : "+mapinfo.subType.get(i)+".valueOf(temp));\n" ;

				code_toConfig+="\t\tres+=\""+mapinfo.subName.get(i)+"=\"+("+mapinfo.subName.get(i)+" == null ? \"\" : "+mapinfo.subName.get(i)+")+\"\\r\\n\";\r\n";

				code_toString+="\t\t\"\\\""+mapinfo.subName.get(i)+"\\\":\\\"\"+("+mapinfo.subName.get(i)+" == null ? \"\" : "+mapinfo.subName.get(i)+")+\"\\\",\"+\r\n";
				code_query+="\t\t\t\ttemp=rs.getString(\""+mapinfo.subName.get(i)+"\");\r\n"
						+ "\t\t\t\tif(temp!=null){\r\n"
						+ "\t\t\t\t\ten.set"+capStr(mapinfo.subName.get(i))+"(new "+mapinfo.subType.get(i)+"(temp));\r\n"
						+ "\t\t\t\t}\r\n";
				code_get+="\t\t\t\ttemp=rs.getString(\""+mapinfo.subName.get(i)+"\");\r\n"
						+ "\t\t\t\tif(temp!=null){\r\n"
						+ "\t\t\t\t\tset"+capStr(mapinfo.subName.get(i))+"(new "+mapinfo.subType.get(i)+"(temp));\r\n"
						+ "\t\t\t\t}\r\n";
				// code_get+="\t\t\t\tset"+capStr(mapinfo.subName.get(i))+"(new "+mapinfo.subType.get(i)+"(rs.getString(\""+mapinfo.subName.get(i)+"\")));\n" ; 

				code_save_1+="?,";
				code_save_2+="\t\t\tpstate.setObject("+(i+1)+",get"+capStr(mapinfo.subName.get(i))+"());\n" ;
				code_update_1+=""+mapinfo.subName.get(i)+"=?,";
				code_update_2+="\t\t\tpstate.setObject("+(i+1)+",get"+capStr(mapinfo.subName.get(i))+"()); \n" ;

			}  
			code_gouzao2+="\t\t} \n" +
					"\t}\r\n"; 
			code_get_wu="\tpublic "+capStr(mapinfo.name)+" get() throws SQLException{ \n" +
					"\t\tString sql=\"select * from "+capStr(mapinfo.name)+" where \";\n" +
					"\t\tList<Object> para=new ArrayList<Object>();\n" +
					code_get_wu_1+
					"\t\tif(sql.indexOf(\" and \")>-1){\n" +
					"\t\t\tsql=sql.substring(0,sql.length()-5);\n" +
					"\t\t}else{\n" +
					"\t\t\tsql=sql.substring(0,sql.length()-7);\n" +
					"\t\t}  \n" +
					"\t\tObject []obj=new Object[para.size()];\n" +
					"\t\tfor (int i = 0; i < para.size(); i++) {\n" +
					"\t\t\tobj[i]=para.get(i);\n" +
					"\t\t}\n" +
					"\t\treturn get(sql,obj);\n" +
					"\t}\n";

			code_query_wu= "\tpublic List<"+capStr(mapinfo.name)+"> query() throws SQLException{ \n" +
					"\t\tString sql=\"select * from "+capStr(mapinfo.name)+" where \";\n" +
					"\t\tList<Object> para=new ArrayList<Object>();\n" +
					code_query_wu_1+
					"\t\tif(sql.indexOf(\" and \")>-1){\n" +
					"\t\t\tsql=sql.substring(0,sql.length()-5);\n" +
					"\t\t}else{\n" +
					"\t\t\tsql=sql.substring(0,sql.length()-7);\n" +
					"\t\t}  \n" +
					"\t\tObject []obj=new Object[para.size()];\n" +
					"\t\tfor (int i = 0; i < para.size(); i++) {\n" +
					"\t\t\tobj[i]=para.get(i);\n" +
					"\t\t}\n" +
					"\t\treturn query(sql,obj);\n" +
					"\t}\n";
			code_update_2+="\t\t\tpstate.setObject("+(mapinfo.subName.size()+1)+",get"+capStr(mapinfo.id)+"()); \n" ;
			code_update_1=code_update_1.substring(0,code_update_1.length()-1);
			String code_update="\tpublic int update() throws Exception{\n" +
					"\t\tConnection conn=null;  \n" +
					"\t\tResultSet rs=null;\n" +
					"\t\tPreparedStatement pstate=null; \n" +
					"\t\tStringBuilder sb=new StringBuilder(); \n" +
					"\t\tString sql=\"update "+capStr(mapinfo.name)+" set "+code_update_1+" where "+capStr(mapinfo.id)+"=?\";\n" +
					"\t\tsb.append(\""+capStr(mapinfo.name)+".update:\").append(sql).append(\";参数:\").append(this.toString()); \n" + 
					 
					"\t\ttry { \n" +
					"\t\t\tconn = DataBase.getConnection();\n" +
					"\t\t\tpstate = conn.prepareStatement(sql); \n" +
					code_update_2 + 
					"\t\t\tlong t1=new Date().getTime();\n"+
					"\t\t\tint res=pstate.executeUpdate();\n"+
					"\t\t\tlong t2=new Date().getTime();\n"+
					"\t\t\tsb.append(\";耗时:\");\n" +
					"\t\t\tsb.append(t2-t1);\n" +
					"\t\t\tsb.append(\"毫秒\");\n" +
					"\t\t\tLog.i(sb.toString());\n" +
					"\t\t\treturn res;\n" +
					"\t\t} catch (Exception e) {\n" +
					"\t\t\tLog.e(e,\"sql:\"+sql);\n" +
					"\t\t\tthrow e;\n" +
					"\t\t}finally{\n" +
					"\t\t\tDataBase.close(conn,rs,pstate);\n" +
					"\t\t} \n" +
					"\t}\r\n";


			code_save_1=code_save_1.substring(0,code_save_1.length()-1);
			code_save_3=code_save_3.substring(0,code_save_3.length()-1);
			String code_save="\tpublic int save() throws Exception{\n" +
					"\t\tConnection conn=null;  \n" +
					"\t\tResultSet rs=null;\n" +
					"\t\tPreparedStatement pstate=null; \n" +
					"\t\tStringBuilder sb=new StringBuilder(); \n" +
					"\t\tString sql=\"insert into "+capStr(mapinfo.name)+" ("+code_save_3+") values("+code_save_1+")\";\n" + 
					"\t\tsb.append(\""+capStr(mapinfo.name)+".save:\").append(sql).append(\";参数:\").append(this.toString()); \n" + 
				 
					"\t\ttry { \n" +
					"\t\t\tconn = DataBase.getConnection();\n" +
					"\t\t\tpstate = conn.prepareStatement(sql); \n" ;
			code_save+="\t\t\tset"+capStr(mapinfo.id)+"(new Integer(DataBase.gzbCache.getIncr(\"db_"+capStr(mapinfo.id)+"_auto_id_incr\").toString()));\n";
			code_save+=code_save_2; 
			code_save+= "\t\t\tlong t1=new Date().getTime();\n"+
					"\t\t\tint res=pstate.executeUpdate();\n"+
					"\t\t\tlong t2=new Date().getTime();\n"+
					"\t\t\tsb.append(\";耗时:\");\n" +
					"\t\t\tsb.append(t2-t1);\n" +
					"\t\t\tsb.append(\"毫秒\");\n" +
					"\t\t\tLog.i(sb.toString());\n" +
					"\t\t\treturn res;\n" +
					"\t\t}catch(java.sql.SQLIntegrityConstraintViolationException e){\n" +
					"\t\t\te.printStackTrace();\n" +
					"\t\t\tset"+capStr(mapinfo.id)+"(new "+capStr(mapinfo.name)+"(\"select * from "+capStr(mapinfo.name)+" order by "+mapinfo.id+" desc limit 1\",null).get"+capStr(mapinfo.id)+"());\n" +
					"\t\t\tDataBase.gzbCache.set(\"db_"+ capStr(mapinfo.id) +"_auto_id_incr\", get"+capStr(mapinfo.id)+"());\n" +
					"\t\t\treturn save();\n" + 
					"\t\t} catch (Exception e) {\n" +
					"\t\t\tLog.e(e,sb.toString());\n" +
					"\t\t\tthrow e;\n" +
					"\t\t}finally{\n" +
					"\t\t\tDataBase.close(conn,rs,pstate);\n" +
					"\t\t} \n" + 
					"\t}\r\n";

			code_query+="\t\t\t\tlist.add(en);\n" +
					"\t\t\t}\n" +
					"\t\t} catch (Exception e) {\n" +
					"\t\t\tLog.e(e,sb.toString());\n" +
					"\t\t}finally{\n" +
					"\t\t\tDataBase.close(conn,rs,pstate);\n" +
					"\t\t} \n" +
					"\t\treturn list;\n" +
					"\t}\r\n";
			code_get+="\t\t\t}else{\r\n\t\t\t\tthis.runState=false;\n}\r\n";
			code_get+="\t\t} catch (Exception e) {\n" +
					"\t\t\tLog.e(e,sb.toString());\n" +
					"\t\t}finally{\n" +
					"\t\t\tDataBase.close(conn,rs,pstate);\n" +
					"\t\t} \n" +
					"\t\treturn this;\n" +
					"\t}\r\n";

			code_para+="\tprivate List<?> obj;\r\n"; 
			code_para+="\tprivate boolean runState=false;\r\n";
			code_para+="\tpublic boolean runState(){\r\n";
			code_para+="\t\treturn runState;\r\n";
			code_para+="\t}\r\n"; 

			code_toString+="\t\t\"\\\"obj\\\":\"+(obj==null ? \"[]\" : obj)+\r\n";  

			code_toConfig+="\t\treturn res;\r\n";
			code_toConfig+="\t}\r\n"; 
			code_toString+="\t\t\"}\";\r\n";
			code_toString+="\t\treturn res;\r\n";
			code_toString+="\t}\r\n";
			code_gouzao1_2=code_gouzao1_2.substring(0,code_gouzao1_2.length()-2);
			code_gouzao1+=code_gouzao1_2+"){\r\n";
			code_gouzao1+=code_gouzao1_1;
			code_gouzao1+="\t}\r\n";





			code+=code_para;
			code+=code_getset;
			code+="\tpublic "+capStr(mapinfo.name)+"(){\r\n"; 
			code+="\t\r\n"; 
			code+="\t}\r\n"; 
			code+=code_gouzao1;
			code+=code_gouzao2;
			code+="\tpublic "+capStr(mapinfo.name)+"(String sql,Object []para){\n" +
					"\t\ttry {\n" + 
					"\t\t\tget(sql,para);\n" +
					"\t\t} catch (SQLException e) { \n" +
					"\t\t\te.printStackTrace();\n" +
					"\t\t}\n" +
					"\t}\n";
			code+=code_toConfig;
			code+=code_toString;
			code+=code_query;
			code+=code_query_fenye;

			code+=code_query_wu;
			code+=code_get;
			code+=code_get_wu;

			code+=code_save;
			code+=code_delete;
			code+=code_update; 

			code+="}\r\n";
			String url= Info.getProjectPath()+"../../src/main/java/gzb/db/"+dbName+"/entity/"+capStr(mapinfo.name)+".java";

			 FileTool.fileNew(url);
			FileTool.fileSaveString(url, code, false); 
			System.out.println(url);


		}
		System.out.println("end");
	}

	public static List<mapInfo> getMapInfo() throws SQLException{
		List<mapInfo> list=new ArrayList<mapInfo>();
		Connection conn= DataBase.getConnection();
		DatabaseMetaData meta = conn.getMetaData();
		PreparedStatement ps = null;
		ResultSet rs = meta.getTables(null, null, null, new String[]{"TABLE"});  
		while(rs.next()){  
			String tbname= rs.getString("TABLE_NAME").toLowerCase();   
			mapInfo mi =new mapInfo();
			mi.name=tbname;
			ps = conn.prepareStatement("select * from "+tbname);
			ResultSetMetaData col = ps.getMetaData();   
			ResultSet rst =meta.getPrimaryKeys(null,null,tbname); 
			rst.next(); 
			String idname=rst.getString("COLUMN_NAME"); 
			mi.id=idname;
			System.out.println(idname); 
			mi.subName=new ArrayList<String>();
			mi.subType=new ArrayList<String>(); 
			for(int i=1;i<=col.getColumnCount();i++){
				String columnClassName = col.getColumnClassName(i);
				String columnName = col.getColumnName(i);  
				mi.subName.add(lowStr(columnName));
				mi.subType.add(columnClassName); 
			} 
			list.add(mi);
		} 
		return list;
	}
	public static String capStr(String name) { 
		return name.substring(0, 1).toUpperCase()+(name.substring(1, name.length()));
	} 
	//首字母转小写
	public static String lowStr(String s){
		if(Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}
	public static void autoAminPage(List<mapInfo> list) throws Exception{ 
		String temp_html_index="";
		for (mapInfo mapinfo : list) { 
			String action_code="";
			String temp_action_save_1="";
			String temp_action_save_2="";
			String temp_html_1="";
			String temp_html_2=""; 
			String temp_html_3="";  
			String temp_action_save_all_1="";
			String temp_action_save_all_2="";
			String temp_action_save_all_3="";
			String temp_action_save_all_4="";
			for (int i = 0; i < mapinfo.subName.size(); i++) { 
				temp_action_save_1+="\t\t\ten.set"+capStr(mapinfo.subName.get(i))+"(new "+mapinfo.subType.get(i)+"(TextTool.textBase64Decoder("+mapinfo.subName.get(i)+")));\n";
				temp_action_save_2+="String "+mapinfo.subName.get(i)+", ";
				temp_html_1+=mapinfo.subName.get(i)+"/";
				temp_html_2+="  postData+='"+mapinfo.subName.get(i)+"'+'='+Base64.encode(data."+mapinfo.subName.get(i)+").replace(/\\+/g,'-').replace(/\\=/g,'_')+'&';\n";
				temp_html_3+="        ,{field:'"+mapinfo.subName.get(i)+"', title:'"+mapinfo.subName.get(i)+"', edit: 'text',width:"+ ((int)1500/mapinfo.subName.size())+", sort: true}\n" ;
				temp_action_save_all_1+="String "+mapinfo.subName.get(i)+"_val,String "+mapinfo.subName.get(i)+"_type,";
				temp_action_save_all_2+="\t\t\t\t"+mapinfo.subName.get(i)+"_type=TextTool.textBase64Decoder("+mapinfo.subName.get(i)+"_type);\n";
				temp_action_save_all_3+= "\t\t\t\tif("+mapinfo.subName.get(i)+"_type.equals(\"-100\")){\n" +
						"\t\t\t\t\ten.set"+capStr(mapinfo.subName.get(i))+"(new "+mapinfo.subType.get(i)+"(TextTool.textBase64Decoder("+mapinfo.subName.get(i)+"_val)));//固定值(输入值)\n" +
						"\t\t\t\t}else if("+mapinfo.subName.get(i)+"_type.equals(\"-101\")){\n" +
						"\t\t\t\t\ten.set"+capStr(mapinfo.subName.get(i))+"(new "+mapinfo.subType.get(i)+"(TextTool.tetGetString(new java.lang.Integer(TextTool.textBase64Decoder("+mapinfo.subName.get(i)+"_val))))); //随机字符[字母-数字](输入值为长度)\n" +
						"\t\t\t\t}else if("+mapinfo.subName.get(i)+"_type.equals(\"-102\")){\n" +
						"\t\t\t\t\ten.set"+capStr(mapinfo.subName.get(i))+"(new "+mapinfo.subType.get(i)+"(TextTool.textBase64Decoder("+mapinfo.subName.get(i)+"_val))+i); //数字自增[数字](输入值)\n" +
						"\t\t\t\t}\n";
				temp_action_save_all_4+=mapinfo.subType.get(i)+"/";


			} 
			temp_action_save_2=temp_action_save_2.substring(0,temp_action_save_2.length()-2);
			temp_html_1=temp_html_1.substring(0,temp_html_1.length()-1); 
			temp_action_save_all_4=temp_action_save_all_4.substring(0,temp_action_save_all_4.length()-1); 

			action_code= 
					"package com.action;\n" +
							"import gzb.db."+dbName+".entity.*;\n" +
							"import gzb.tools.*;\n" +
							"import org.springframework.stereotype.Controller;\n" +
							"import org.springframework.web.bind.annotation.RequestMapping;\n" +
							"import org.springframework.web.bind.annotation.ResponseBody;\n" +
							"@Controller\n" +
							"public class "+capStr(mapinfo.name)+"AdminPageApi {\n" +
							"\t@RequestMapping(value = \"/"+capStr(mapinfo.name)+"List\", produces = \"application/json;charset=UTF-8\") \n" +
							"\t@ResponseBody()\n" +
							"\tpublic String "+capStr(mapinfo.name)+"List(Integer page,Integer limit){\n" +
							"\t\ttry {\n" +
							"\t\t\treturn new "+capStr(mapinfo.name)+"().query(page,limit).toJson();\n" +
							"\t\t} catch (Exception e) {\n" +
							"\t\t\tLog.e(e);\n" +
							"\t\t\treturn WebTool.jsonError();\n" +
							"\t\t}\n" +
							"\t}\n" +
							"\t@RequestMapping(value = \"/"+capStr(mapinfo.name)+"Save\", produces = \"application/json;charset=UTF-8\") \n" +
							"\t@ResponseBody()\n" +
							"\tpublic String "+capStr(mapinfo.name)+"Save("+temp_action_save_2+"){\n" +
							"\t\ttry {\n" +
							"\t\t\t"+capStr(mapinfo.name)+" en=new "+capStr(mapinfo.name)+"();\n" +
							temp_action_save_1+
							"\t\t\ten.save();\n" +
							"\t\t\treturn WebTool.jsonSuccess(\"保存完成\");\n" +
							"\t\t} catch (Exception e) {\n" +
							"\t\t\tLog.e(e);\n" +
							"\t\t\treturn WebTool.jsonError();\n" +
							"\t\t}\n" +
							"\t}\n"+
							"\t@RequestMapping(value = \"/"+capStr(mapinfo.name)+"SaveAll\", produces = \"application/json;charset=UTF-8\") \n" +
							"\t@ResponseBody()\n" +
							"\tpublic String "+capStr(mapinfo.name)+"SaveAll("+temp_action_save_all_1+"int saveNum\n" +
							"\t\t\t){\n" +
							"\t\ttry {\n" +
							"\t\t\t"+capStr(mapinfo.name)+" en=null; \n" +
							temp_action_save_all_2 +
							"\t\t\tfor (int i = 0; i < saveNum; i++) {\n" +
							"\t\t\t\ten=new "+capStr(mapinfo.name)+"();\n" +
							temp_action_save_all_3 + 
							"\t\t\t\ten.save(); \n" +
							"\t\t\t}\n" +
							"\n" +
							"\t\t\treturn WebTool.jsonSuccess(\"生成完成\");\n" +
							"\t\t} catch (Exception e) {\n" +
							"\t\t\tLog.e(e);\n" +
							"\t\t\treturn WebTool.jsonError();\n" +
							"\t\t}\n" +
							"\t}"+
							"\t@RequestMapping(value = \"/"+capStr(mapinfo.name)+"Update\", produces = \"application/json;charset=UTF-8\") \n" +
							"\t@ResponseBody()\n" +
							"\tpublic String "+capStr(mapinfo.name)+"Update("+temp_action_save_2+"){\n" +
							"\t\ttry {\n" + 
							"\t\t\t"+capStr(mapinfo.name)+" en=new "+capStr(mapinfo.name)+"();\n" +
							temp_action_save_1+
							"\t\t\ten.update();\n" +
							"\t\t\treturn WebTool.jsonSuccess(\"修改完成\");\n" +
							"\t\t} catch (Exception e) {\n" +
							"\t\t\tLog.e(e);\n" +
							"\t\t\treturn WebTool.jsonError();\n" +
							"\t\t}\n" +
							"\t}\n" +
							"\t@RequestMapping(value = \"/"+capStr(mapinfo.name)+"Delete\", produces = \"application/json;charset=UTF-8\") \n" +
							"\t@ResponseBody()\n" +
							"\tpublic String "+capStr(mapinfo.name)+"Delete(String []id){\n" +
							"\t\ttry {\n" +
							"\t\t\t for (String string : id) {\n" +
							"\t\t\t\t new "+capStr(mapinfo.name)+"().set"+capStr(mapinfo.id)+"(new Integer(TextTool.textBase64Decoder(string))).delete(); \n" +
							"\t\t\t} \n" +
							"\t\t\treturn WebTool.jsonSuccess(\"删除完成\");\n" +
							"\t\t} catch (Exception e) {\n" +
							"\t\t\tLog.e(e);\n" +
							"\t\t\treturn WebTool.jsonError();\n" +
							"\t\t}\n" +
							"\t}\n" +
							"}\n";
			System.out.println(action_code);
			String url=Info.getProjectPath()+"/src/com/action/"+capStr(mapinfo.name)+"AdminPageApi.java";
			FileTool.fileNew(url);
			FileTool.fileSaveString(url, action_code, false); 


			String temp_addPage= "<!DOCTYPE html>\n" +
					"<html>\n" +
					"<head>\n" +
					"  <meta charset='utf-8'>\n" +
					"  <title>表单组合</title>\n" +
					"  <meta name='renderer' content='webkit'>\n" +
					"  <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'>\n" +
					"  <meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0'>\n" +
					"  <link rel='stylesheet' href='layuiadmin/layui/css/layui.css' media='all'>\n" +
					"  <link rel='stylesheet' href='layuiadmin/style/admin.css' media='all'>\n" +
					"</head>\n" +
					"<body>\n" +
					"  <div class='layui-fluid'>\n" +
					"    <div class='layui-card'>\n" +
					"      <div class='layui-card-header'>表单组合</div>\n" +
					"      <div class='layui-card-body' style='padding: 15px;'>\n" +
					"        <form class='layui-form' id='form_id' lay-filter='component-form-group' >\n" +
					"        </form>\n" +
					"          <div class='layui-form-item'>\n" +
					"            <label class='layui-form-label'> </label>\n" +
					"            <div class='layui-input-block'> \n" +
					"              <button class='layui-btn layui-btn-normal' id='saveData'>提交数据</button> \n" +
					"            </div>\n" +
					"          </div>\n" +
					"      </div>\n" +
					"    </div>\n" +
					"  </div> \n" +
					"  <script src='layuiadmin/layui/layui.js'></script>  \n" +
					"  <script src='base64.js'></script>  \n" +
					"  <script>\n" +
					"  layui.config({\n" +
					"    base: 'layuiadmin/' //静态资源所在路径\n" +
					"  }).extend({\n" +
					"    index: 'lib/index' //主入口模块\n" +
					"  }).use(['index', 'form', 'laydate'], function(){\n" +
					"    var $ = layui.$\n" +
					"    ,admin = layui.admin\n" +
					"    ,element = layui.element\n" +
					"    ,layer = layui.layer\n" +
					"    ,laydate = layui.laydate\n" +
					"    ,form = layui.form;\n" +
					" let names='"+temp_html_1+"'.split('/');\n" +
					"\taddInput(names);\n" +
					"    form.render(null, 'component-form-group');\n" +
					"    laydate.render({\n" +
					"      elem: '#LAY-component-form-group-date'\n" +
					"    });\n" +
					"  $('#saveData').click(function(){\n" +
					"  let postData='';\n" +
					"  for(let n of names){\n" +
					"  postData+=n+'='+Base64.encode($('#'+n).val()).replace(/\\+/g,'-').replace(/\\=/g,'_')+'&';\n" +
					"  }\n" +
					"  $.post('../"+capStr(mapinfo.name)+"Save',postData,function(res){\n" +
					"   if(res.state == '1'){\n" +
					"         layer.msg(res.msg, {offset: '15px',icon: 1,time: 1000}, function(){ });\n" +
					"         } \n" +
					"         if(res.state == '2'){\n" +
					"         layer.msg(res.msg, {offset: '15px',icon: 2,time: 1000}, function(){ });\n" +
					"         } \n" +
					"         if(res.state == '3'){\n" +
					"         layer.msg(res.msg, {offset: '15px',icon: 2,time: 1000}, function(){ });\n" +
					"         }  \n" +
					"  });\n" +
					"  });\n" +
					"    function addInput(arr){\n" +
					"    let htm='';\n" +
					"    for(let n of arr){\n" +
					"    htm+= '<div class=\\'layui-form-item\\'>\\n' +\n" +
					"'            <label class=\\'layui-form-label\\'>'+n+'</label>\\n' +\n" +
					"'            <div class=\\'layui-input-block\\'>\\n' +\n" +
					"'              <input type=\\'text\\' id=\\''+n+'\\' lay-verify=\\'title\\' autocomplete=\\'off\\' placeholder=\\'请输入'+n+'\\' class=\\'layui-input\\'>\\n' +\n" +
					"'            </div>\\n' +\n" +
					"'          </div>\\n';\n" +
					"    }\n" +
					"    $('#form_id').html(htm);\n" +
					"    }\n" +
					"  });\n" +
					"  </script>\n" +
					"</body>\n" +
					"</html>\n";

			url=Info.getProjectPath()+"/WebRoot/scriptAdminPage/Add"+capStr(mapinfo.name)+".html";
			FileTool.fileNew(url);
			FileTool.fileSaveString(url, temp_addPage, false); 



			String AddAll="<!DOCTYPE html>\n" +
					"<html>\n" +
					"<head>\n" +
					"  <meta charset=\"utf-8\">\n" +
					"  <title>生成测试数据</title>\n" +
					"  <meta name=\"renderer\" content=\"webkit\">\n" +
					"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0\">\n" +
					"  <link rel=\"stylesheet\" href=\"layuiadmin/layui/css/layui.css\" media=\"all\">\n" +
					"  <link rel=\"stylesheet\" href=\"layuiadmin/style/admin.css\" media=\"all\">\n" +
					"</head>\n" +
					"<body> \n" +
					"  <div class=\"layui-fluid\">\n" +
					"    <div class=\"layui-row layui-col-space15\">\n" +
					"      <div class=\"layui-col-md6\">\n" +
					"           <form class=\"layui-form\" id=\"form_id\" lay-filter=\"component-form-element\"> \n" +
					"            </form>\n" +
					"             <div class='layui-form-item'>\n" +
					"            <label class='layui-form-label'> </label>\n" +
					"            <div class='layui-input-block'> \n" +
					"              <button class='layui-btn layui-btn-normal' id='saveData'>生成测试数据</button> \n" +
					"            </div>\n" +
					"          </div>\n" +
					"      </div>\n" +
					"    </div>\n" +
					"  </div> \n" +
					"  <script src=\"layuiadmin/layui/layui.js\"></script>  \n" +
					"  <script src='base64.js'></script>  \n" +

	    "  <script>\n" +
	    "  layui.config({\n" +
	    "    base: 'layuiadmin/' //静态资源所在路径\n" +
	    "  }).extend({\n" +
	    "    index: 'lib/index' //主入口模块\n" +
	    "  }).use(['index', 'form'], function(){\n" +
	    "    var $ = layui.$\n" +
	    "    ,admin = layui.admin\n" +
	    "    ,element = layui.element\n" +
	    "    ,form = layui.form;\n" + 
	    "    let names='"+temp_html_1+"'.split('/');\n" +
	    "    let types='"+temp_action_save_all_4+"'.split('/'); \n" +
	    "    addInput(names,types); \n" +
	    "    form.render(null, 'component-form-element');\n" +
	    "    element.render('breadcrumb', 'breadcrumb'); \n" +
	    "     $('#saveData').click(function(){\n" +
	    "  let postData='';\n" +
	    "for(var i=0;i<names.length;i++){\n" +
	    "  postData+=names[i]+\"_val\"+'='+Base64.encode($('#'+names[i]+\"_val\").val()).replace(/\\+/g,'-').replace(/\\=/g,'_')+'&';\n" +
	    "  postData+=names[i]+\"_type\"+'='+Base64.encode($('#'+names[i]+\"_type\").val()).replace(/\\+/g,'-').replace(/\\=/g,'_')+'&';\n" +
	    "  }\npostData+='saveNum='+$('#saveNum').val();\r\n" +
	    "  $.post('../"+capStr(mapinfo.name)+"SaveAll',postData,function(res){\n" +
	    "         if(res.state == '1'){\n" +
	    "         layer.msg(res.msg, {offset: '15px',icon: 1,time: 1000}, function(){ });\n" +
	    "         } \n" +
	    "         if(res.state == '2'){\n" +
	    "         layer.msg(res.msg, {offset: '15px',icon: 2,time: 1000}, function(){ });\n" +
	    "         } \n" +
	    "         if(res.state == '3'){\n" +
	    "         layer.msg(res.msg, {offset: '15px',icon: 2,time: 1000}, function(){ });\n" +
	    "         }\n  "+ 
	    "  });\n" +
	    "  }); \n" +
	    "    function addInput(arr) {\n" +
	    "    var htm=\"<div class='layui-form-item'>\\n\" +\n" +
	    "    \"            <label class='layui-form-label'>生成数量:</label>\\n\" +\n" +
	    "    \"            <div class='layui-input-block'>\\n\" +\n" +
	    "    \"              <input type='text' id='saveNum' lay-verify='title' autocomplete='off' placeholder='请输入生成数量' class='layui-input'>\\n\" +\n" +
	    "    \"            </div>\\n\" +\n" +
	    "    \"          </div>\\n\";\n" +
	    "\t\tfor(var i=0;i<arr.length;i++){\n" +
	    "\t\thtm+= \"<div class='layui-row layui-col-space10 layui-form-item'> \\n\" +\n" +
	    "    \"                <div class='layui-col-lg6'>\\n\" +\n" +
	    "    \"                  <label class='layui-form-label'>\"+arr[i]+\"：</label>\\n\" +\n" +
	    "    \"                  <div class='layui-input-block'>\\n\" +\n" +
	    "    \"                    <input value='1' type='text' id='\"+arr[i]+\"_val' lay-verify='required' placeholder='' autocomplete='off' class='layui-input'>\\n\" +\n" +
	    "    \"                  </div>\\n\" +\n" +
	    "    \"                </div> \\n\" +\n" +
	    "    \"                <div class='layui-col-lg6'>\\n\" +\n" +
	    "    \"                  <label class='layui-form-label'>生成类型：</label>\\n\" +\n" +
	    "    \"                  <div class='layui-input-block'>\\n\" +\n" +
	    "    \"                    <select id='\"+arr[i]+\"_type' lay-verify='required' lay-filter='aihao'> \\n\" +\n" +
	    "    \"                      <option value='-100'>固定值(输入值)</option>\\n\";\n" +
	    "    if(types[i] == \"java.lang.String\"){\n" +
	    "    htm+=\"                      <option value='-101'>随机字符[字母-数字](输入值为长度)</option> \\n\";\n" +
	    "    }\n" +
	    "    htm+=\"                      <option value='-102'>数字自增[数字](输入值)</option> \\n\" +\n" +
	    "    \"                    </select>\\n\" +\n" +
	    "    \"                  </div>\\n\" +\n" +
	    "    \"                </div> \\n\" +\n" +
	    "    \"              </div> \\n\";\n" +
	    "\t\t}\n" +
	    "\t\t$('#form_id').html(htm); \n" +
	    "\t}\n" +
	    "  });\n" +
	    "  </script>\n" +
	    "</body>\n" +
	    "</html>";

			url=Info.getProjectPath()+"/WebRoot/scriptAdminPage/AddAll"+capStr(mapinfo.name)+".html";
			FileTool.fileNew(url);
			FileTool.fileSaveString(url, AddAll, false); 



			String listCode= "\n" +
					"\n" +
					"\n" +
					"<!DOCTYPE html>\n" +
					"<html>\n" +
					"<head>\n" +
					"  <meta charset='utf-8'>\n" +
					"  <title>开启单元格编辑 - 数据表格</title>\n" +
					"  <meta name='renderer' content='webkit'>\n" +
					"  <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'>\n" +
					"  <meta name='viewport' content='width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0'>\n" +
					"  <link rel='stylesheet' href='layuiadmin/layui/css/layui.css' media='all'>\n" +
					"  <link rel='stylesheet' href='layuiadmin/style/admin.css' media='all'>\n" +
					"</head>\n" +
					"<body> \n" +
					"  <div class='layui-card layadmin-header'>\n" +
					"    <div class='layui-breadcrumb' lay-filter='breadcrumb'>\n" +
					"      <a lay-href=''>主页</a>\n" +
					"      <a><cite>组件</cite></a>\n" +
					"      <a><cite>数据表格</cite></a>\n" +
					"      <a><cite>开启单元格编辑</cite></a>\n" +
					"    </div>\n" +
					"  </div> \n" +
					"  <div class='layui-fluid'>\n" +
					"    <div class='layui-row layui-col-space15'>\n" +
					"      <div class='layui-col-md12'>\n" +
					"        <div class='layui-card'>\n" +
					"          <div class='layui-card-header'>脚本信息</div>\n" +
					"          <div class='layui-card-body'> \n" +
					"          <div class='layui-btn-group test-table-operate-btn' style='margin-bottom: 10px;'>\n" +
					"              <button class='layui-btn' data-type='getCheckData'>删除选中项</button>\n" +
					"              <!-- <button class='layui-btn' data-type='getCheckLength'>获取选中数目</button>\n" +
					"              <button class='layui-btn' data-type='isAll'>验证是否全选</button> -->\n" +
					"            </div> \n" +
					"            <table class='layui-hide' id='test-table-operate' lay-filter='test-table-operate'></table>\n" +
					"          </div>\n" +
					"        </div>\n" +
					"      </div>\n" +
					"    </div>\n" +
					"  </div> \n" +
					"  <script src='layuiadmin/layui/layui.js'></script> \n" +
					"  <script src='base64.js'></script>   \n" +
					"  <script>\n" +
					"  layui.config({\n" +
					"    base: 'layuiadmin/' //静态资源所在路径\n" +
					"  }).extend({\n" +
					"    index: 'lib/index' //主入口模块\n" +
					"  }).use(['index', 'table'], function(){\n" +
					"    var table = layui.table;\n" +
					"    var $ = layui.jquery\n" +
					"     let names='"+temp_html_1+"'.split('/');\n" +
					"    table.render({\n" +
					"      elem: '#test-table-operate'\n" +
					"      ,url: '../"+capStr(mapinfo.name)+"List'\n" +
					"      ,cols: [[\n" +
					"        {type:'checkbox'}\n\n\n" +
					temp_html_3+ 
					"      ]]\n" +
					"       ,page: true\n" +
					"    }) \n" +
					"    //监听单元格编辑\n" +
					"    table.on('edit(test-table-cellEdit)', function(obj){\n" +
					"      var value = obj.value //得到修改后的值\n" +
					"      ,data = obj.data //得到所在行所有键值\n" +
					"      ,field = obj.field; //得到字段 \n" +
					"      let postData='';\n" +
					temp_html_2+ 
					"         $.post('../"+capStr(mapinfo.name)+"Update',postData,function(res){\n" +
					"        if(res.state=='1'){\n" +
					"            layer.msg(res.msg, {offset: '15px',icon: 1,time: 1000}, function(){\n" +
					"            }); \n" +
					"            return;\n" +
					"        }\n" +
					"        if(res.state=='2' || res.state=='3'){\n" +
					"            layer.msg(res.msg, {offset: '15px',icon: 2,time: 1000}, function(){\n" +
					"            });\n" +
					"            return;\n" +
					"        }\n" +
					"        if(res.state=='4'){\n" +
					"            layer.msg(res.msg, {offset: '15px',icon: 2,time: 2000}, function(){\n" +
					"                location.href = res.url; //后台主页\n" +
					"            });\n" +
					"            return;\n" +
					"        }\n" +
					"    });\n" +
					" \n" +
					"    });\n" +
					"      \n" +
					"    //监听表格复选框选择\n" +
					"    table.on('checkbox(test-table-operate)', function(obj){\n" +
					"      console.log(obj)\n" +
					"    });\n" +
					"    //监听工具条\n" +
					"    table.on('tool(test-table-operate)', function(obj){\n" +
					"      var data = obj.data;\n" +
					"      if(obj.event === 'detail'){\n" +
					"        layer.msg('ID：'+ data.id + ' 的查看操作');\n" +
					"      } else if(obj.event === 'del'){\n" +
					"        layer.confirm('真的删除行么', function(index){\n" +
					"          obj.del();\n" +
					"          layer.close(index);\n" +
					"        });\n" +
					"      } else if(obj.event === 'edit'){\n" +
					"        layer.alert('编辑行：<br>'+ JSON.stringify(data))\n" +
					"      }\n" +
					"    });\n" +
					"    \n" +
					"    var $ = layui.$, active = {\n" +
					"      getCheckData: function(){ //获取选中数据\n" +
					"        var checkStatus = table.checkStatus('test-table-operate')\n" +
					"        ,data = checkStatus.data;\n" +
					"      let postData='';\n" +
					"        for(let i=0;i<data.length;i++){\n" +
					"  postData+='"+mapinfo.id+"'+'='+Base64.encode(data[i]."+mapinfo.id+").replace(/\\+/g,'-').replace(/\\=/g,'_')+'&'; \n" +
					"        }\n" +
					"        $.post('../"+capStr(mapinfo.name)+"Delete',postData,function(res){\n" +
					"        if(res.state=='1'){\n" +
					"            layer.msg(res.msg, {offset: '15px',icon: 1,time: 1000}, function(){\n" +
					"            }); \n" +
					"            return;\n" +
					"        }\n" +
					"        if(res.state=='2' || res.state=='3'){\n" +
					"            layer.msg(res.msg, {offset: '15px',icon: 2,time: 1000}, function(){\n" +
					"            });\n" +
					"            return;\n" +
					"        }\n" +
					"        if(res.state=='4'){\n" +
					"            layer.msg(res.msg, {offset: '15px',icon: 2,time: 2000}, function(){\n" +
					"                location.href = res.url; //后台主页\n" +
					"            });\n" +
					"            return;\n" +
					"        }\n" +
					"    });\n" +
					"       /*  layer.alert(JSON.stringify(data)); */\n" +
					"      }\n" +
					"      ,getCheckLength: function(){ //获取选中数目\n" +
					"        var checkStatus = table.checkStatus('test-table-operate')\n" +
					"        ,data = checkStatus.data;\n" +
					"        layer.msg('选中了：'+ data.length + ' 个');\n" +
					"      }\n" +
					"      ,isAll: function(){ //验证是否全选\n" +
					"        var checkStatus = table.checkStatus('test-table-operate');\n" +
					"        layer.msg(checkStatus.isAll ? '全选': '未全选')\n" +
					"      }\n" +
					"    };\n" +
					"    \n" +
					"    $('.test-table-operate-btn .layui-btn').on('click', function(){\n" +
					"      var type = $(this).data('type');\n" +
					"      active[type] ? active[type].call(this) : '';\n" +
					"    });\n" +
					"  });\n" +
					"  </script>\n" +
					"</body>\n" +
					"</html>"; 

			url=Info.getProjectPath()+"/WebRoot/scriptAdminPage/List"+capStr(mapinfo.name)+".html";
			FileTool.fileNew(url);
			FileTool.fileSaveString(url, listCode, false); 
			temp_html_index+="select =new Select();\n" +
					"select.name=\""+capStr(mapinfo.name)+"\";\n" +
					"select.list_name.add(\"生成测试数据\");\n" +
					"select.list_url.add(\"AddAll"+capStr(mapinfo.name)+".html\"); \n" +
					"select.list_name.add(\"数据添加\");\n" +
					"select.list_url.add(\"Add"+capStr(mapinfo.name)+".html\");\n" +
					"select.list_name.add(\"数据列表\");\n" +
					"select.list_url.add(\"List"+capStr(mapinfo.name)+".html\"); \n" +
					"list.add(select);\n";


		}

		String url=Info.getProjectPath()+"/WebRoot/AutoAdminPage/index.jsp";
		FileTool.fileNew(url);
		String temp=FileTool.fileReadString(url+".jsp");
		FileTool.fileSaveString(url, temp.replace("/////替换代码/////", temp_html_index), false); 
	}
}
class mapInfo{
	public String name="";
	public String id="";
	public List<String> subName=null;
	public List<String> subType=null;

}
