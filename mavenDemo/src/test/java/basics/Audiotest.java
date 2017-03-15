package basics;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audiotest extends Thread {

	// 1.������Ƶ�ļ��ı�����������Ҫ��һ�����ڴ洢��Ƶ�ļ��������ֵ�String���� filename
	private String filename;

	// 2.���캯������ʼ��filename
	public Audiotest(String filename) {
		this.filename = filename;
	}

	// 3.�߳����к�����д
	@Override
	public void run() {

		// 1.����һ���ļ��������ã�ָ����Ϊfilename�Ǹ��ļ�
		File sourceFile = new File(filename);
		// ����һ��AudioInputStream���ڽ����������Ƶ����
		AudioInputStream audioInputStream = null;
		// ʹ��AudioSystem����ȡ��Ƶ����Ƶ������
		try {
			audioInputStream = AudioSystem.getAudioInputStream(sourceFile);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 4,��AudioFormat����ȡAudioInputStream�ĸ�ʽ
		AudioFormat format = audioInputStream.getFormat();
		// 5.Դ������SoureDataLine�ǿ���д�����ݵ�������
		SourceDataLine auline = null;
		// ��ȡ��������֧�ֵ���Ƶ��ʽDataLine.info
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		// �����ָ��info������ƥ�����
		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			// �򿪾���ָ����ʽ���У�������ʹ�л����������ϵͳ��Դ����ÿɲ���
			auline.open();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ����ĳһ��������ִ������i/o
		auline.start();

		// д������
		int nBytesRead = 0;
		byte[] abData = new byte[2];
		// ����Ƶ����ȡָ������������������ֽڣ����������������ֽ������С�
		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				// ͨ����Դ�����н�����д���Ƶ��
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			auline.drain();
			auline.close();
		}

	}

}
