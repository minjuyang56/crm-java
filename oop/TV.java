package oop;

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
        this.channel = channel;
    }

    public void channel(Boolean up){
        if (up){
            this.channel += 1;
        }
    }

    public void volume(int volume){
        this.volume = volume;
    }

    public void volume(Boolean up){
        if (up){
            this.volume += 1;
        }
    }

    public void status(){
        System.out.println(String.format("채널: %s", this.channel));
        System.out.println(String.format("채널: %s", this.volume));
        System.out.println(String.format("채널: %s", this.power));
        System.out.println("구웃");
        System.out.println();
    }
}
