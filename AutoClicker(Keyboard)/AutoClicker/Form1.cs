using System;
using System.Runtime.InteropServices;
using System.Threading;
using System.Windows.Forms;
using Microsoft.VisualBasic;
using System.Windows.Input;
using Keyboard = System.Windows.Input.Keyboard;
using System.Runtime.CompilerServices;
using System.Drawing;
using System.Diagnostics.Eventing.Reader;

namespace AutoClicker
{
    public partial class Form1 : Form
    {
        public string StartStopKey = "F";
        public bool Start = false, keyPress = false, auto = false;
        Thread th;
        public Form1()
        {
            InitializeComponent();
            CheckForIllegalCrossThreadCalls = false;
            keyboardWorkerL.RunWorkerAsync();
            keyboardWorkerR.RunWorkerAsync();
            leftClickDetector.RunWorkerAsync();
            rightClickDetector.RunWorkerAsync();
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            StartBinding.Text = StartStopKey;
        }

        [DllImport("User32.dll")]
        public static extern short GetAsyncKeyState(Keys ArrowKeys);



        bool isRunningL = false;
        private void AutoClickListenerStart_Click(object sender, EventArgs e)
        {
            if (AutoClickListenerStart.Text.Contains("Start"))
            {
                if (MouseCPS.Value != 0)
                {
                    AutoClickListenerStart.Text = "Stop Pressing";

                    leftClickTimer.Interval = 100000 / (MouseCPS.Value);
                    leftClickTimer.Start();
                    isRunningL = true;
                }
            }
            else
            {
                AutoClickListenerStart.Text = "Start Pressing";
                AutoClickListenerStart.BackColor = Color.FromArgb(((int)(((byte)(90)))), ((int)(((byte)(12)))), ((int)(((byte)(14)))));
                AutoClickListenerStart.ForeColor = Color.FromArgb(((int)(((byte)(175)))), ((int)(((byte)(131)))), ((int)(((byte)(53)))));
                Start = false;
                isRunningL = false;
            }
        }

        [DllImport("user32.dll")]
        static extern void mouse_event(uint dwFlags, int dx, int dy, uint dwData, UIntPtr dwExtraInfo);


        [DllImport("user32.dll")] 
        static extern uint keybd_event(byte bVk, byte bScan, int dwFlags, int dwExtraInfo);

        public static void KeyDown(Keys key)
        {
            keybd_event((byte)key, 0, 0, 0);
        }

        public static void KeyUp(Keys key)
        {
            keybd_event((byte)key, 0, 0x0002, 0);
        }

        const uint LeftD = 0x0002;
        const uint LeftU = 0x0004;



        [DllImport("user32.dll")]
        public static extern bool GetAsyncKeyState(int button);


        public static bool IsMouseButtonPressed(MouseButton button)
        {
            return GetAsyncKeyState((int)button);
        }

        public enum MouseButton
        {
            LeftMouseButton = 0x01,
            RightMouseButton = 0x02,
            MiddleMouseButton = 0x04,
        }

        private void exit_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
            Application.Exit();
        }

        private void CPS_Scroll(object sender, EventArgs e)
        {
            CPSLabel.Text = (float)(MouseCPS.Value)/100 + " CPS";
        }
        private void ClickTimer_Tick(object sender, EventArgs e)
        {
            if (!autoClick.Checked && keyPress && Start)
            {
                KeyDown(Keys.D7);
                Thread.Sleep(1);
                KeyUp(Keys.D7);
                Thread.Sleep(5);
                KeyDown(Keys.D8);
                Thread.Sleep(1);
                KeyUp(Keys.D8);
            }
            else if (autoClick.Checked && Start)
            {
                KeyDown(Keys.D7);
                Thread.Sleep(1);
                KeyUp(Keys.D7);
                Thread.Sleep(5);
                KeyDown(Keys.D8);
                Thread.Sleep(1);
                KeyUp(Keys.D8);
            }
            else { return; }
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            Environment.Exit(0);
            Application.Exit();
        }

        private void leftClickDetector_DoWork(object sender, System.ComponentModel.DoWorkEventArgs e)
        {
            while (true)
            {
                if (IsMouseButtonPressed(MouseButton.LeftMouseButton))
                {
                    keyPress = true;
                }
                else
                {
                    keyPress = false;
                }
            }
        }

        private void keyboardWorkerL_DoWork(object sender, System.ComponentModel.DoWorkEventArgs e)
        {
            while (true)
            {
                if (isRunningL)
                {
                    if (GetAsyncKeyState((Keys)Char.Parse(StartStopKey)) < 0)
                    {
                        if (Start)
                        {
                            AutoClickListenerStart.BackColor = Color.FromArgb(((int)(((byte)(90)))), ((int)(((byte)(12)))), ((int)(((byte)(14)))));
                            AutoClickListenerStart.ForeColor = Color.FromArgb(((int)(((byte)(175)))), ((int)(((byte)(131)))), ((int)(((byte)(53)))));
                            Start = false;
                            Thread.Sleep(300);
                        }
                        else
                        {
                            AutoClickListenerStart.BackColor = System.Drawing.Color.Green;
                            AutoClickListenerStart.ForeColor = System.Drawing.Color.White;
                            Start = true;
                            Thread.Sleep(300);
                        }
                    }
                }
            }
        }
        private void leftMouseBinding_Click(object sender, EventArgs e)
        {
            StartStopKey = Interaction.InputBox("Start/Stop Key", "Give Your Start Stop Key", "F", 0, 0);
            StartStopKey = StartStopKey.ToUpper();
            StartBinding.Text = StartStopKey;
        }
    }
}
