// Rabu, 27 Feb 2019

import java.util.Scanner;

class Rumah
{
	boolean sudahPunyaPasangan;
	int x;
	int y;
}

class FormingQuizTeams
{
	static double totalJarak = 0;
	static double jarakMinimum = -1;

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int banyakGrup = scan.nextInt();
		int quiz = 0;
		String output = "";
		while (banyakGrup != 0)
		{
			quiz++;
			int banyakRumah = 2 * banyakGrup;
			Rumah[] arrayRumah = new Rumah[banyakRumah];
			for (int i = 0; i < banyakRumah; i++)
			{
				arrayRumah[i] = new Rumah();
				scan.next();
				arrayRumah[i].x = scan.nextInt();
				arrayRumah[i].y = scan.nextInt();
			}

			pilihPasangan(arrayRumah);

			output += ("Case " + quiz + ": " + String.format("%.2f", jarakMinimum) + "\n");
			// Source: https://stackoverflow.com/a/10959585/9157799
			
			banyakGrup = scan.nextInt();
			jarakMinimum = -1;
		}
		System.out.print(output);
	}

	static void pilihPasangan(Rumah[] arrayRumah)
	{
		// Pilih rumah pertama yang belum punya pasangan
		int i;
		Rumah rumahPertama = null;
		for (i = 0; i < arrayRumah.length; i++)
		{
			if (arrayRumah[i].sudahPunyaPasangan == false)
			{
				rumahPertama = arrayRumah[i];
				arrayRumah[i].sudahPunyaPasangan = true;
				break;
			}
		}

		// Pilih rumah kedua yang belum punya pasangan
		for (i++; i < arrayRumah.length; i++)
		{
			if (arrayRumah[i].sudahPunyaPasangan == false)
			{
				Rumah rumahKedua = arrayRumah[i];
				rumahKedua.sudahPunyaPasangan = true;
				double jarakDuaRumah = jarakDuaRumah(rumahPertama, rumahKedua);
				totalJarak += jarakDuaRumah;

				// Jika masih ada yang belum punya pasangan
				if (masihAdaYangBelumPunyaPasangan(arrayRumah))
					pilihPasangan(arrayRumah);
				else // Sudah punya pasangan semua
				{
					if (totalJarak < jarakMinimum || jarakMinimum == -1)
						jarakMinimum = totalJarak;

					rumahPertama.sudahPunyaPasangan = false;
				}

				totalJarak -= jarakDuaRumah;
				// Hilangkan jejak
				rumahKedua.sudahPunyaPasangan = false;
			}
		}
		rumahPertama.sudahPunyaPasangan = false;
	}

	static double jarakDuaRumah(Rumah a, Rumah b)
	{
		int selisihX = Math.abs(b.x - a.x);
		int selisihY = Math.abs(b.y - a.y);

		// c^2 = a^2 + b^2
		double jarak = Math.sqrt( Math.pow(selisihX, 2) + Math.pow(selisihY, 2) );
		return jarak;
	}

	static boolean masihAdaYangBelumPunyaPasangan(Rumah[] arrayRumah)
	{
		for (int i = arrayRumah.length - 1; i > 0; i--)
			if (arrayRumah[i].sudahPunyaPasangan == false)
				return true;
		return false;
	}
}
