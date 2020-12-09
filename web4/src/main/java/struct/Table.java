package struct;

import java.util.Vector;

public class Table {
    private final Vector<Linkman> tableinfo;
    //对应初始化列表
    public Table(){
        tableinfo = new Vector<Linkman>();
        tableinfo.add(new Linkman(
                "wmz", "17333695199", "915799721@qq.com", "北京市西土城路10号", "915799721"
        ));
    }
    //返回当前的列表全内容
    public Vector<Linkman> getTable(){
        return tableinfo;
    }
}
