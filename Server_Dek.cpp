#include <iostream>
#include <fstream>
#include <windows.h>
using namespace std;
struct Person {
    char name[25];
    int marks[4];
    
}B;
int answer;
long size_pred;
int main()
{
    setlocale(LC_ALL, "rus");
    ifstream fR;
    ofstream fA;
    char buffer[50];
    const char* nameR = "Z:\REQUEST.bin";
    const char* nameA = "Z:\ANSWER.bin";

    cout << "server is working" << endl;
    // начальные установки
    fR.open(nameR, ios::binary);
    //открытие файла REQUEST
    fR.seekg(0, ios::end);
    size_pred = fR.tellg();
    //стартовая позиция сервера в файле REQUEST
    fR.close();

    // начало работы сервера
    while (true)
    {
        fR.open(nameR, ios::binary);
        //открытие файла REQUEST
        fR.seekg(0, ios::end);
        //переход в конец файла REQUEST
        // есть новые запросы от клиентов? 
        while (size_pred >= fR.tellg())
        {
            Sleep(100); fR.seekg(0, ios::end);
        }

        fR.seekg(size_pred, ios::beg);
        //переход к началу полученного запроса
        fR.read((char*)&B, sizeof(B));
        //считывание данных клиента
        size_pred = fR.tellg();
        // на конец обработанных данных
        fR.close();
        // определение индекса массы	

        
        if (find(begin(B.marks), end(B.marks), 2) == end(B.marks) && ) {
            
            answer = 1;
        }
        else {
            answer = 0;
        }

        // передача ответа клиенту
        fA.open(nameA, ios::binary | ios::app);
        //открытие файла ANSWER
        fA.write((char*)&answer, sizeof(answer));
        //запись ответа клиенту
        fA.close();
    }// while






}

