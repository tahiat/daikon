// Test for Issue 293:
// https://github.com/typetools/checker-framework/issues/293
// @skip-test

class Issue293 {
    void foobar() {
    void test1() {
        String s;
        try {
            s = read();
@@ -19,6 +19,37 @@ void foobar() {
        write(s);
    }

    void test2() {
        String s2 = "";
        try {
        } finally {
            write(s2);
        }
    }

    void test3() throws Exception {
        String s = "";
        try {
            throw new Exception();
        } finally {
            write(s);
        }
    }

    void test4() throws Exception {
        String s = "";
        try {
            if (true) {
                throw new Exception();
            } else {
                s = null;
            }
        } finally {
            //:: error: argument.type.incompatible
            write(s);
        }
    }

    String read() throws Exception {
        throw new Exception();
    }