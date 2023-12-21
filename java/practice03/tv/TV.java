package practice03.tv;

public class TV {
    private int channel;
    private int volume;
    private boolean power;

    public TV (int channel, int volume, boolean power){
        this.channel = channel;
        this.volume = volume;
        this.power = power;
    }

    public void power(boolean on){
        this.power = on;
    }

    public void channel(int channel){
        if (channel > 255){
            this.channel = 255;
        } else if (channel < 1){
            this.channel = 1;
        } else {
            this.channel = channel;
        }
    }

    public void channel(Boolean up){
        if (up == true && (this.channel < 255)){
            this.channel += 1;
        }else if (up == false && (this.channel > 1)){
            this.channel -= 1;
        }
    }

    public void volume(int volume){
        if (volume > 100){
            this.volume = 100;
        } else if (volume < 0){
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    public void volume(Boolean up){
        if (up == true && (this.volume < 100)){
            this.volume += 1;
        }else if (up == false && (this.volume > 0)){
            this.volume -= 1;
        }
    }

    public void status(){
        System.out.println(String.format("채널: %s", this.channel));
        System.out.println(String.format("볼륨: %s", this.volume));
        System.out.println(String.format("전원: %s", this.power));
        System.out.println("---------------------------------------------------");
        System.out.println();
    }
}
