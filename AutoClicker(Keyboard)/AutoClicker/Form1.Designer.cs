using System.Drawing;

namespace AutoClicker
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.leftMousePanel = new System.Windows.Forms.Panel();
            this.autoClick = new System.Windows.Forms.CheckBox();
            this.AutoClickListenerStart = new System.Windows.Forms.Button();
            this.StartBinding = new System.Windows.Forms.Button();
            this.CPSLabel = new System.Windows.Forms.Label();
            this.MouseCPS = new System.Windows.Forms.TrackBar();
            this.rightClickTimer = new System.Windows.Forms.Timer(this.components);
            this.leftClickTimer = new System.Windows.Forms.Timer(this.components);
            this.keyboardWorkerL = new System.ComponentModel.BackgroundWorker();
            this.keyboardWorkerR = new System.ComponentModel.BackgroundWorker();
            this.leftClickDetector = new System.ComponentModel.BackgroundWorker();
            this.rightClickDetector = new System.ComponentModel.BackgroundWorker();
            this.leftMousePanel.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.MouseCPS)).BeginInit();
            this.SuspendLayout();
            // 
            // leftMousePanel
            // 
            this.leftMousePanel.Controls.Add(this.autoClick);
            this.leftMousePanel.Controls.Add(this.AutoClickListenerStart);
            this.leftMousePanel.Controls.Add(this.StartBinding);
            this.leftMousePanel.Controls.Add(this.CPSLabel);
            this.leftMousePanel.Controls.Add(this.MouseCPS);
            this.leftMousePanel.Location = new System.Drawing.Point(12, 12);
            this.leftMousePanel.Name = "leftMousePanel";
            this.leftMousePanel.Size = new System.Drawing.Size(351, 545);
            this.leftMousePanel.TabIndex = 0;
            // 
            // autoClick
            // 
            this.autoClick.AutoSize = true;
            this.autoClick.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.autoClick.ForeColor = System.Drawing.Color.White;
            this.autoClick.Location = new System.Drawing.Point(273, 46);
            this.autoClick.Name = "autoClick";
            this.autoClick.Size = new System.Drawing.Size(75, 29);
            this.autoClick.TabIndex = 7;
            this.autoClick.Text = "Auto";
            this.autoClick.UseVisualStyleBackColor = true;
            // 
            // AutoClickListenerStart
            // 
            this.AutoClickListenerStart.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(90)))), ((int)(((byte)(12)))), ((int)(((byte)(14)))));
            this.AutoClickListenerStart.Cursor = System.Windows.Forms.Cursors.Hand;
            this.AutoClickListenerStart.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.AutoClickListenerStart.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.AutoClickListenerStart.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(175)))), ((int)(((byte)(131)))), ((int)(((byte)(53)))));
            this.AutoClickListenerStart.Location = new System.Drawing.Point(160, 3);
            this.AutoClickListenerStart.Name = "AutoClickListenerStart";
            this.AutoClickListenerStart.Size = new System.Drawing.Size(188, 37);
            this.AutoClickListenerStart.TabIndex = 3;
            this.AutoClickListenerStart.Text = "Start Pressing";
            this.AutoClickListenerStart.UseVisualStyleBackColor = false;
            this.AutoClickListenerStart.Click += new System.EventHandler(this.AutoClickListenerStart_Click);
            // 
            // StartBinding
            // 
            this.StartBinding.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(90)))), ((int)(((byte)(12)))), ((int)(((byte)(14)))));
            this.StartBinding.Cursor = System.Windows.Forms.Cursors.Hand;
            this.StartBinding.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.StartBinding.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.StartBinding.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(175)))), ((int)(((byte)(131)))), ((int)(((byte)(53)))));
            this.StartBinding.Location = new System.Drawing.Point(160, 46);
            this.StartBinding.Name = "StartBinding";
            this.StartBinding.Size = new System.Drawing.Size(107, 60);
            this.StartBinding.TabIndex = 2;
            this.StartBinding.Text = "F";
            this.StartBinding.UseVisualStyleBackColor = false;
            this.StartBinding.Click += new System.EventHandler(this.leftMouseBinding_Click);
            // 
            // CPSLabel
            // 
            this.CPSLabel.AutoSize = true;
            this.CPSLabel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(71)))), ((int)(((byte)(69)))), ((int)(((byte)(56)))));
            this.CPSLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(162)));
            this.CPSLabel.ForeColor = System.Drawing.Color.White;
            this.CPSLabel.Location = new System.Drawing.Point(65, 3);
            this.CPSLabel.Name = "CPSLabel";
            this.CPSLabel.Size = new System.Drawing.Size(70, 25);
            this.CPSLabel.TabIndex = 1;
            this.CPSLabel.Text = "0 CPS";
            // 
            // MouseCPS
            // 
            this.MouseCPS.Location = new System.Drawing.Point(3, 3);
            this.MouseCPS.Maximum = 1000;
            this.MouseCPS.Name = "MouseCPS";
            this.MouseCPS.Orientation = System.Windows.Forms.Orientation.Vertical;
            this.MouseCPS.Size = new System.Drawing.Size(56, 539);
            this.MouseCPS.TabIndex = 0;
            this.MouseCPS.Scroll += new System.EventHandler(this.CPS_Scroll);
            // 
            // leftClickTimer
            // 
            this.leftClickTimer.Interval = 1000;
            this.leftClickTimer.Tick += new System.EventHandler(this.ClickTimer_Tick);
            // 
            // keyboardWorkerL
            // 
            this.keyboardWorkerL.WorkerSupportsCancellation = true;
            this.keyboardWorkerL.DoWork += new System.ComponentModel.DoWorkEventHandler(this.keyboardWorkerL_DoWork);
            // 
            // leftClickDetector
            // 
            this.leftClickDetector.WorkerSupportsCancellation = true;
            this.leftClickDetector.DoWork += new System.ComponentModel.DoWorkEventHandler(this.leftClickDetector_DoWork);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(71)))), ((int)(((byte)(69)))), ((int)(((byte)(56)))));
            this.ClientSize = new System.Drawing.Size(381, 569);
            this.Controls.Add(this.leftMousePanel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.Text = "Clicker";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.Load += new System.EventHandler(this.Form1_Load);
            this.leftMousePanel.ResumeLayout(false);
            this.leftMousePanel.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.MouseCPS)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel leftMousePanel;
        private System.Windows.Forms.Label CPSLabel;
        private System.Windows.Forms.Button StartBinding;
        private System.Windows.Forms.Button AutoClickListenerStart;
        private System.Windows.Forms.Timer rightClickTimer;
        private System.Windows.Forms.Timer leftClickTimer;
        private System.ComponentModel.BackgroundWorker keyboardWorkerL;
        private System.ComponentModel.BackgroundWorker keyboardWorkerR;
        private System.ComponentModel.BackgroundWorker leftClickDetector;
        private System.ComponentModel.BackgroundWorker rightClickDetector;
        private System.Windows.Forms.CheckBox autoClick;
        private System.Windows.Forms.TrackBar MouseCPS;
    }
}

