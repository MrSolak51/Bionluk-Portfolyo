#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QTcpSocket>
#include <QMessageBox>
#include <QCloseEvent>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QString username, QWidget *parent = nullptr);
    ~MainWindow();
    void closeEvent (QCloseEvent *event);

private slots:
    void on_sendMessagePushButton_clicked();

private:
    Ui::MainWindow *ui;
    QTcpSocket *socket;
    QByteArray Data;
    QString username;
    QString userId;
    bool userSucc;
    void SendToServer(QString str);
public slots:
    void slotReadyRead();
};
#endif // MAINWINDOW_H
