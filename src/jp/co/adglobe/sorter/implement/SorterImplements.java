package jp.co.adglobe.sorter.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jp.co.adglobe.sorter.Sorter;

class SorterImplements implements Sorter {

	// データの出力先ディレクトリ
	private static final String OUTPUT_DIR = "data/output/";
	// 入力データの格納ディレクトリ
	private static final String INPUT_DIR = "data/input/";
	// ソート対象のデータを格納するリスト
	private static List<Integer> list = new ArrayList<>();

	/*
	 * ソート実行メソッド
	 *
	 *
	 * ソート済みのテキストファイルを出力します。
	 *
	 * @param filepath ソート対象のテキストファイルのパス
	 */
	public void doExec(String filename) {
		try{
			File file = new File(INPUT_DIR + filename);
			FileReader filereader = new FileReader(file);
			BufferedReader reader = new BufferedReader(filereader);

			String a = reader.readLine();
			while (a != null){
				System.out.println("reader: "+a);
				list.add(Integer.parseInt(a));
				a = reader.readLine();
			}
			reader.close();

			// 対象のリストをソートする
	        //SorterImplements bs = new SorterImplements();
	        this.bubbleSearch(list);

			File file1 = new File("newfile.txt");
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file1)));

			for(Integer str : list){
				pw.println(str);
			}

            //ファイルに書き出す
            pw.close();

            //終了メッセージを画面に出力する
            System.out.println("出力が完了しました。");

		} catch(Exception e) {
			System.out.println("エラーが起こりました");
			e.getStackTrace();
		}

		// このメソッド内に処理を記述
		System.out.println(filename);

	}



	private void bubbleSearch(List<Integer> bubble) {

		// 比較の終点 = i
		int size = bubble.size();
		int s1;
		int s2;
		int s3;
		for (int i = 0; i < size; i++) {

			// 終点まで比較する = j
			for (int j = size - 1; j - 1 >= i; j--) {
				// s1,s2はlist中の比較する値
				s1 = bubble.get(j);
				s2 = bubble.get(j - 1);

				//入れ替えたときに変数s2が消えてしまうので避難させる
				s3 = s2;

				// s2の方が大きければ値を入れ替える
				if (s2 > s1) {
					bubble.set(j - 1, s1);
					bubble.set(j, s3);
				}
			}
		}
	}


}



