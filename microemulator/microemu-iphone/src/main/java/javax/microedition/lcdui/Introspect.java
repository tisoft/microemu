package javax.microedition.lcdui;

public class Introspect {

    public static ChoiceGroup getChoiceGroup(List list) {
        return list.choiceGroup;
    }

    public static void setChoiceGroup(List list, ChoiceGroup cg) {
        list.choiceGroup = cg;
    }

    public static void setType(ChoiceGroup cg, int type){
        cg.choiceType=type;
    }

    public static int getType(ChoiceGroup cg){
        return cg.choiceType;
    }
}
