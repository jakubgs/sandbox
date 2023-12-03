#include <QApplication>
#include <QFileDialog>
#include <QDebug>

class QFileDialogTester : public QWidget
{
public:
  void openFile()
  {
    QString filename =  QFileDialog::getOpenFileName(
          this,
          "Open Document",
          QDir::currentPath(),
          "All files (*.*) ;; Document files (*.doc *.rtf);; PNG files (*.png)");

    if( !filename.isNull() )
    {
      qDebug() << "selected file path : " << filename.toUtf8();
    }
  }
};


int main( int argc, char **argv )
{
  QApplication app( argc, argv );

  QFileDialogTester test;
  test.openFile();

  return 0;
}
