package com.rong.flora.animal;

import java.util.*;

/**
 * Created by rongwf1 on 2016/6/18.
 */
public class Fight {
    private Date date;
    private String  address;
    private Animal judge;
    private Animal fighter1;
    private  Animal fighter2;
    private Boolean result;
    private Integer duration;
    private static final Integer MAX_DURATION = 60;
    private static final String WINKEY = "win" ;
    private static final String LOSEKEY = "lose" ;
    private static final Integer TENMIN = 10;
    private static final Integer TWENTYMIN = 20;
    private static final Integer FORTYMIN = 40;
    private static final Integer ONEHOUR = 60;
    private static List<Fight> info;
    private static Map<String ,List<Fight>> infoWithResult;
    private static Map<Integer ,List<Fight>> infoWithDuration;

    static {
        info = new LinkedList<>();
        infoWithResult = new HashMap<>();
        infoWithDuration = new HashMap<>();
        infoWithResult.put(WINKEY, new LinkedList<>());
        infoWithResult.put(LOSEKEY, new LinkedList<>());
        infoWithDuration.put(TENMIN, new LinkedList<>());
        infoWithDuration.put(TWENTYMIN, new LinkedList<>());
        infoWithDuration.put(FORTYMIN, new LinkedList<>());
        infoWithDuration.put(ONEHOUR, new LinkedList<>());

    }

    public Fight(Date date, String address, Animal judge, Animal fighter1, Animal fighter2) {
        this.date = date;
        this.address = address;
        this.judge = judge;
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.duration = 0;
    }

    public static Map<String, List<Fight>> getInfoWithResult() {
        return infoWithResult;
    }

    public static void setInfoWithResult(Map<String, List<Fight>> infoWithResult) {
        Fight.infoWithResult = infoWithResult;
    }

    public static List<Fight> getInfo() {
        return info;
    }

    public static void setInfo(List<Fight> info) {
        Fight.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Animal getJudge() {
        return judge;
    }

    public void setJudge(Animal judge) {
        this.judge = judge;
    }

    public Animal getFighter1() {
        return fighter1;
    }

    public void setFighter1(Animal fighter1) {
        this.fighter1 = fighter1;
    }

    public Animal getFighter2() {
        return fighter2;
    }

    public void setFighter2(Animal fighter2) {
        this.fighter2 = fighter2;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Fight{" +
                "date=" + date +
                ", address='" + address + '\'' +
                ", judge=" + judge +
                ", fighter1=" + fighter1 +
                ", fighter2=" + fighter2 +
                ", result=" + result +
                '}';
    }

    private Boolean fighting(){
        Integer chance = new Random().nextInt(3);

        if (fighter1.getClass().getName().equals(fighter2.getClass().getName())){
            this.result = new Random().nextBoolean();
        } else {
            this.result = fighter1 instanceof Cat? chance != 2 : chance ==2;
        }
        this.duration = new Random().nextInt(MAX_DURATION);

        // add fight to statistics info list
        Fight.info.add(this);
        Fight.infoWithResult.get(result ?WINKEY: LOSEKEY).add(this);
        this.addFightToDurationMap();
        return this.result;

    }

    public static List<Fight> getFightswithResult(String result){
        if(infoWithResult.containsKey(result)) {
            return infoWithResult.get(result);
        } else{
            return null;
        }
    }

    public static List<Fight> getFightsWithResult(String result) {
        return infoWithResult.containsKey(result)?infoWithResult.get(result):null;
    }

    public static List<Fight> getAllFightsWithResult(Boolean result){
        List<Fight> fights = new LinkedList<>();
        for(int i = 0; i < info.size(); i++){
            if( info.get(i).getResult().equals(result)){
                fights.add(info.get(i));
            }
        }
        return fights;
    }

    public static List<Fight> getFightListForAssignedJudge1(Animal judge){

        List<Fight> fightList = new LinkedList<>();
        Fight.info.forEach(fight -> {
            if(fight.getJudge().equals(judge)){
                fightList.add(fight);
            }
        });
        return fightList;
    }

    public static List<Fight> getFightListForAssignedJudge2(Animal judge) {

        List<Fight> fightList = new LinkedList<>();
        Iterator<Fight> it = info.iterator();
        while (it.hasNext()){
            Fight f = it.next();
            if (f.getJudge().equals(judge)){
                fightList.add(f);
            }
        }
        return fightList;
    }

    public static List<Fight> getFightListForAssignedJudge(Animal judge){

        List<Fight> fightList = new LinkedList<>();
        for( int i = 0; i < info.size() ; i++){

           if(Fight.getInfo().get(i).getJudge().equals(judge)){
               fightList.add(Fight.info.get(i));
           }
        }

        return fightList;
    }

    public static List<Fight> getFightingListOfJudge(Animal judge) {
        List<Fight> fights = new LinkedList<>();
        info.stream().filter(fight ->{
            return fight.getJudge().equals(judge);}).forEach(fights::add);

        return fights;
    }

    private void addFightToDurationMap(){
        if(this.duration <= TENMIN ){
            infoWithDuration.get(TENMIN).add(this);
        }else if (this.duration >= 10 && this.duration <= 20){
            infoWithDuration.get(TWENTYMIN).add(this);
        }else if(this.duration >= 20 && this.duration <= 40){
            infoWithDuration.get(FORTYMIN).add(this);
        }else if(this.duration >= 40 && this.duration < 60){
            infoWithDuration.get(ONEHOUR).add(this);
        }
    }

    public static void main(String[] args){
        Fight fight = new Fight(new Date(), "sh",
                new Cat("ears", "eyes", "legs", "mouse","miao", "ive" ),
                new Cat("ears", "eyes", "legs", "mouse", "miao", "fiona"),
                new Dog("ears","eyes", "legs", "mouse"));
         fight.fighting();
        fight.fighting();
       List<Fight> fightlist = Fight.getFightListForAssignedJudge (new Cat("ears", "eyes", "legs", "mouse","miao", "ive" ));
        List<Fight> wins = Fight.getFightsWithResult("win");
        System.out.println(wins);
        //System.out.println(fightlist);
//        System.out.println(fight);
//        fight.fighting();
//        System.out.println(fight);
//        fight.fighting();
//        System.out.println(fight);


    }
}
