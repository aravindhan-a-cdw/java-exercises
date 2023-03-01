package exercise_4.behavioural_pattern;

public class CommandPattern {

	public static void main(String[] args) {
		UniversalRemote genie = new UniversalRemote();

		Tv tv = new Tv();
		SetTopBox sbox = new SetTopBox();
		SoundSystem ss = new SoundSystem();
		VGame vgame = new VGame();

		Command newscommand = new NewsChannelCommand(tv, sbox, ss, vgame);
		Command serialcommand = new SerialChannelCommand(tv, sbox, ss, vgame);
		Command ttgamecommand = new TTGameCommand(tv, sbox, ss, vgame);

		genie.assignCommand(1, ttgamecommand);
		genie.assignCommand(2, newscommand);
		genie.assignCommand(3, serialcommand);

		genie.executeCommand(1);
	}

}


class UniversalRemote {
	Command c[] = new Command[5];

	public UniversalRemote() {
		for (int i = 0; i < 5; i++) {
			c[i] = new DummyCommand();
		}
	}

	public void executeCommand(int slot) {
		c[slot].execute();
	}

	public void assignCommand(int slot, Command command) {
		c[slot] = command;
	}
}

abstract class Command {
	Tv tv;
	SetTopBox sbox;
	SoundSystem ss;
	VGame vgame;

	public Command() {}

	public Command(Tv tv, SetTopBox sbox, SoundSystem ss, VGame vgame) {
		this.tv = tv;
		this.sbox = sbox;
		this.ss = ss;
		this.vgame = vgame;
	}

	public abstract void execute();
}

class DummyCommand extends Command {
	@Override
	public void execute() {
		System.out.println("i am a dummy slot.....yet to be assigned a process...");
	}
}

class NewsChannelCommand extends Command {
	public NewsChannelCommand(Tv tv, SetTopBox sbox, SoundSystem ss, VGame vgame) {
		super(tv, sbox, ss, vgame);
	}

	@Override
	public void execute() {
		System.out.println("the news channel process started...");
		tv.av1();
		sbox.newChannel();
		ss.increaseVolume();
		System.out.println("enjoy the news channel....");
	}
}

class SerialChannelCommand extends Command {
	public SerialChannelCommand(Tv tv, SetTopBox sbox, SoundSystem ss, VGame vgame) {
		super(tv, sbox, ss, vgame);
	}

	@Override
	public void execute() {
		System.out.println("the serial channel process started...");
		tv.av1();
		sbox.serialChannel();
		ss.increaseVolume();
		System.out.println("enjoy the saas bahu serial channel....");
	}
}

class TTGameCommand extends Command {
	public TTGameCommand(Tv tv, SetTopBox sbox, SoundSystem ss, VGame vgame) {
		super(tv, sbox, ss, vgame);
	}

	@Override
	public void execute() {
		System.out.println("the ttgame process started...");
		tv.av2();
		vgame.ttgame();
		ss.decreaseVolume();
		System.out.println("enjoy the tt game....");
	}
}

class Tv {
	public void av1() {
		System.out.println("av1 mode...");
	}

	public void av2() {
		System.out.println("av2 mode...");
	}
}

class SetTopBox {
	public void newChannel() {
		System.out.println("news channel...");
	}

	public void serialChannel() {
		System.out.println("mamiyar marumaga serial channel...");
	}
}

class SoundSystem {
	public void increaseVolume() {
		System.out.println("volume increased...");
	}

	public void decreaseVolume() {
		System.out.println("volume decreased...");
	}
}

class VGame {
	public void ttgame() {
		System.out.println("tt game started...");
	}

	public void snooker() {
		System.out.println("snooker game...");
	}
}