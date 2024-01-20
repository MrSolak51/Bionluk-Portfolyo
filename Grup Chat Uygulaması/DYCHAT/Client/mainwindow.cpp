#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QString username, QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    socket = new QTcpSocket(this);
    socket->connectToHost("127.0.0.1", 2323);

    this->userSucc = false;
    this->username = username;
    SendToServer("USERNAME" + this->username);

    connect(socket, &QTcpSocket::readyRead, this, &MainWindow::slotReadyRead);
    connect(socket, &QTcpSocket::disconnected, socket, &QTcpSocket::deleteLater);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::closeEvent (QCloseEvent *event)
{
    QApplication::quit();
}

void MainWindow::on_sendMessagePushButton_clicked()
{

    QListWidgetItem *messageItem = new QListWidgetItem("you: " +  ui->inputMessageLineEdit->text());
    messageItem->setTextAlignment(Qt::AlignRight);
    ui->messages->insertItem(ui->messages->count(), messageItem);
    SendToServer(username + ": " + ui->inputMessageLineEdit->text());
    ui->inputMessageLineEdit->clear();
}

void MainWindow::SendToServer(QString str)
{
    Data.clear();
    QDataStream out(&Data, QIODevice::WriteOnly);
    out.setVersion(QDataStream::Qt_6_2);
    out << str;
    socket->write(Data);
}

void MainWindow::slotReadyRead()
{
    QDataStream in(socket);
    in.setVersion(QDataStream::Qt_6_2);
    if (in.status() == QDataStream::Ok) {
       QString str;
       in >> str;
       if (str.contains("USERNAMEEXIST") && !this->userSucc) {
           QMessageBox messageBox;
           messageBox.critical(0,"Error","Username Exist!");
           messageBox.setFixedSize(500,200);
           QApplication::quit();
       }
       else if (str.contains("USERNAMESUCCESS") && str.contains(this->username)) {
           this->userSucc = true;
           this->setWindowTitle(this->username);
       }
       else if (str.contains("USERNAMESUCCESS") && !str.contains(this->username)) {
       }
       else{
           if (!str.contains(username)) {
               QListWidgetItem *messageItem = new QListWidgetItem(str);
               messageItem->setTextAlignment(Qt::AlignLeft);
               ui->messages->insertItem(ui->messages->count(), messageItem);
           }
       }
    }
    else{
        QMessageBox messageBox;
        messageBox.critical(0,"Error","An error has occured !");
        messageBox.setFixedSize(500,200);
    }
}

