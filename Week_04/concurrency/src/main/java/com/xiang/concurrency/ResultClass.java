package com.xiang.concurrency;

public class ResultClass{
        volatile private int result;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }