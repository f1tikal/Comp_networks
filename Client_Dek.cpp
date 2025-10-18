#include <iostream>
#include <fstream>
#include <windows.h>
using namespace std;
// структура данных запроса клиента
struct Person
{
	char name[25];  //имя
	int marks[4];		//рост
} A;
void main() {
	setlocale(LC_ALL, "rus");

	const char* nameR = "Z:\REQUEST.bin";
	//файл для запросов клиентов
	const char* nameA = "Z:\ANSWER.bin";
	//файл для ответов сервера
	ofstream f_REQ;
	ifstream f_ANS;
	long pred_size;
	int answer;
	while (true)
	{
		// передача данных от клиента серверу
		cout << "Введите запрос: Фамилия Рост Вес" << endl;
		cin >> A.name;
		for (int i = 0; i < 4; i++)
		{
			cin >> A.marks[i];
		}
		cout << A.name;
		for (int i = 0; i < 4; i++)
		{
			cout << A.marks[i] << " ";
		}
		f_REQ.open(nameR, ios::app | ios::binary);
		//открытие файла REQUEST 
		f_REQ.write((char*)&A, sizeof(A));
		f_REQ.close();

		f_ANS.open(nameA, ios::binary);
		f_ANS.seekg(0, ios::end);
		pred_size = f_ANS.tellg();

		while (pred_size >= f_ANS.tellg())
		{
			Sleep(100);
			f_ANS.seekg(0, ios::end);
		}
		f_ANS.seekg(pred_size, ios::beg);
		f_ANS.read((char*)&answer, sizeof(answer));
		f_ANS.close();


		switch (answer) {
		case 1: { cout << " Нет долгов\n"; 
			double sr = 0;
			for (int i = 0; i < 4; i++)
			{
				sr += A.marks[i];
			}
			sr /= 4;
			cout << sr;
			if (find(begin(A.marks), end(A.marks), 3) == end(A.marks)) cout << "Нет стипендии\n";
			else
			{
				cout << "Mnogo stipendii \n";
			}
			break; 
		
		}
		case 0: { cout << " Есть долги\n"; break; }
		
		}
	}
}

