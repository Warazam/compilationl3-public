import c3a.*;
import sa.*;

public class Sa2c3a  extends SaDepthFirstVisitor<C3aOperand> {
     private C3a c3a;

     public  C3a getC3a(){
         System.out.println("return");
         return c3a;

     }

     public Sa2c3a(SaNode root){
         c3a = new C3a();
         root.accept(this);
     }

    @Override
    public C3aOperand visit(SaProg node) {
        System.out.println("31");
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaDecTab node) {
        System.out.println("30");
        return new C3aVar(node.tsItem, new C3aTemp(node.getTaille()));
    }

    @Override
    public C3aOperand visit(SaExp node) {
        System.out.println("29");
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpInt node) {
        System.out.println("28");
        return new C3aConstant(node.getVal());
    }

    @Override
    public C3aOperand visit(SaExpVar node) {
        System.out.println("27");
        return node.getVar().accept(this);
    }

    @Override
    public C3aOperand visit(SaInstEcriture node) {
        C3aOperand op = node.getArg().accept(this);
        c3a.ajouteInst(new C3aInstWrite(op, ""));
        System.out.println("26");
        return null;
    }

    @Override
    public C3aOperand visit(SaInstTantQue node) {

        C3aLabel label0 = c3a.newAutoLabel();
        C3aLabel label1 = c3a.newAutoLabel();

        c3a.addLabelToNextInst(label0);
        C3aOperand op1 = node.getTest().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, c3a.False, label1,""));

        node.getFaire().accept(this);
        c3a.ajouteInst(new C3aInstJump(label0,""));
        c3a.addLabelToNextInst(label1);
        System.out.println("25");
        return null;
    }

    @Override
    public C3aOperand visit(SaLInst node) {
        System.out.println("24");
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaDecFonc node) {
        c3a.ajouteInst(new C3aInstFBegin(node.tsItem, "entree fonction"));
        node.getCorps().accept(this);
        c3a.ajouteInst(new C3aInstFEnd(""));
        System.out.println("23");
        return null;
    }

    @Override
    public C3aOperand visit(SaDecVar node) {
        System.out.println("22");
        return null;
    }

    @Override
    public C3aOperand visit(SaInstAffect node) {
        C3aOperand result = node.getLhs().accept(this);
        C3aOperand op1 = node.getRhs().accept(this);
        C3aInstAffect aInstAffect = new C3aInstAffect(op1, result, "");
        c3a.ajouteInst(aInstAffect);
        System.out.println("21");
        return null;
    }

    @Override
    public C3aOperand visit(SaLDec node) {
        System.out.println("20");
         return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaVarSimple node) {
        System.out.println("19");
         return new C3aVar(node.tsItem, null);
    }

    @Override
    public C3aOperand visit(SaAppel node) {
        if(node.getArguments() != null)
            node.getArguments().accept(this);
        c3a.ajouteInst(new C3aInstCall(new C3aFunction(node.tsItem),null,""));
        System.out.println("18");
        return super.visit(node);

    }

    @Override
    public C3aOperand visit(SaExpAppel node) {
        if(node.getVal().getArguments() != null)
            node.getVal().getArguments().accept(this);
        C3aTemp temp = c3a.newTemp();
        c3a.ajouteInst(new C3aInstCall(new C3aFunction(node.getVal().tsItem),temp,""));
        System.out.println("17");
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpAdd node) {
        C3aTemp temp = c3a.newTemp();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);


        c3a.ajouteInst(new C3aInstAdd(op1, op2, temp , ""));
        System.out.println("16");
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpSub node) {
        C3aTemp temp = c3a.newTemp();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstSub(op1, op2, temp , ""));
        System.out.println("15");
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpMult node) {
        C3aTemp temp = c3a.newTemp();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);


        c3a.ajouteInst(new C3aInstMult(op1, op2, temp , ""));
        System.out.println("14");
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpDiv node) {
        C3aTemp temp = c3a.newTemp();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstDiv(op1, op2, temp , ""));
        System.out.println("13");
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpInf node) {
        C3aTemp temp = c3a.newTemp();
        C3aLabel label = c3a.newAutoLabel();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstAffect(c3a.True, temp,""));
        c3a.ajouteInst(new C3aInstJumpIfLess(op1,op2,label,""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, temp,""));

        c3a.addLabelToNextInst(label);
        System.out.println("11");
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpEqual node) {
        C3aTemp temp = c3a.newTemp();
        C3aLabel label = c3a.newAutoLabel();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstAffect(c3a.True, temp,""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1,op2,label,""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, temp,""));
        System.out.println("10");
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpAnd node) {
        C3aTemp temp = c3a.newTemp();
        C3aLabel label0 = c3a.newAutoLabel();
        C3aLabel label1 = c3a.newAutoLabel();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstJumpIfEqual(op1,c3a.False,label1,""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op2,c3a.False,label1,""));

        c3a.ajouteInst(new C3aInstAffect(c3a.True, temp,""));

        c3a.ajouteInst(new C3aInstJump(label0,""));

        c3a.addLabelToNextInst(label1);
        c3a.ajouteInst(new C3aInstAffect(c3a.False, temp,""));
        c3a.addLabelToNextInst(label0);
        System.out.println("9");
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpOr node) {
        C3aTemp temp = c3a.newTemp();
        C3aLabel label0 = c3a.newAutoLabel();
        C3aLabel label1 = c3a.newAutoLabel();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op1,c3a.False,label1,""));
        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op2,c3a.False,label1,""));

        c3a.ajouteInst(new C3aInstAffect(c3a.False, temp,""));

        c3a.ajouteInst(new C3aInstJump(label0,""));

        c3a.addLabelToNextInst(label1);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, temp,""));
        c3a.addLabelToNextInst(label0);
        System.out.println("8");
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpNot node) {
        C3aLabel label = c3a.newAutoLabel();

        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op1,op2,label,""));
        System.out.println("7");
        return op1;
    }

    @Override
    public C3aOperand visit(SaExpLire node) {
        C3aTemp temp = c3a.newTemp();
        c3a.ajouteInst(new C3aInstRead(temp,""));
        System.out.println("6");
        return temp;
    }

    @Override
    public C3aOperand visit(SaInstBloc node) {
        System.out.println("5");
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstSi node) {
        C3aLabel label = c3a.newAutoLabel();

        C3aOperand op1 = node.getTest().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1,c3a.False, label, ""));

        node.getAlors().accept(this);

        if(node.getSinon() != null){
            C3aLabel label1 = c3a.newAutoLabel();
            c3a.ajouteInst(new C3aInstJump(label1,""));
            c3a.addLabelToNextInst(label);
            node.getSinon().accept(this);
            c3a.addLabelToNextInst(label1);
        }
        else
            c3a.addLabelToNextInst(label);
        System.out.println("4");
        return null;
    }

    @Override
    public C3aOperand visit(SaInstRetour node) {
        C3aOperand op = node.getVal().accept(this);
        c3a.ajouteInst(new C3aInstReturn(op,""));
        System.out.println("3");
        return null;
    }

    @Override
    public C3aOperand visit(SaLExp node) {
        if(node.getQueue() != null)
            node.getQueue().accept(this);

        C3aOperand op1 = node.getTete().accept(this);
        c3a.ajouteInst(new C3aInstParam(op1,""));
        System.out.println("2");
        return null;
    }

    @Override
    public C3aOperand visit(SaVarIndicee node) {
        C3aOperand op1 = node.getIndice().accept(this);
        System.out.println("1");
        return new C3aVar(node.tsItem, op1);
    }

}


