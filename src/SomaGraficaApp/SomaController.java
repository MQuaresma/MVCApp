package SomaGraficaApp;

public class SomaController {
    private SomaView view;
    private SomaModel model;

    public void setModel(SomaModel sm){
        this.model=sm;
    }

    public void setView(SomaView sv){
        this.view=sv;
    }

    public void startflow(){
        this.initController();
    }

    public void initController(){
        this.setListeners();
        this.initView();
    }

    public void initView(){
        this.view.getNum1().setText(Integer.toString(this.model.getNum1()));
        this.view.getNum2().setText(Integer.toString(this.model.getNum2()));
        this.view.getSum().setText(Integer.toString(this.model.sum()));
        this.view.getFrame().setVisible(true);
    }

    public void setListeners(){
        this.view.getSumBt().addActionListener(ev -> sumCtrl());
        this.view.getCleanBt().addActionListener(ev -> cleanCtrl());
        this.view.getCloseBt().addActionListener(ev -> closeCtrl());
    }

    public void sumCtrl(){
        this.model.setNum1(Integer.parseInt(this.view.getNum1().getText()));
        this.model.setNum2(Integer.parseInt(this.view.getNum2().getText()));
        this.view.getSum().setText(Integer.toString(this.model.sum()));
    }

    public void cleanCtrl(){
        this.view.getNum1().setText("0");
        this.view.getNum2().setText("0");
        this.view.getSum().setText("0");
        this.model.setNum1(0);
        this.model.setNum2(0);
    }

    public void closeCtrl(){
        this.view.getFrame().setVisible(false);
        this.view.getFrame().dispose();
    }
}
