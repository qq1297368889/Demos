package gzb.tools;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticPara {
	public static String[]temp_Strings=new String [100];
	public static Map<String, Object> map=new HashMap<String, Object>();
	public static Map<String, Class<?>> mapClass=new HashMap<String, Class<?>>();
	public static MapTool mapTool=new MapTool();
	public static List<Socket> list=new ArrayList<Socket>();
	public static GzbCache gzbCache = new GzbCacheMap();
}
