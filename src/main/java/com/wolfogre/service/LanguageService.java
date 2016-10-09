package com.wolfogre.service;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wolfogre on 10/5/16.
 */
@Service
public class LanguageService {

    private List<Map.Entry<String, String>> languageList;
    private HashMap<String, String> languageMap;

    public LanguageService() {
        languageList = new ArrayList<>();
        // 来自 http://highlightjs.readthedocs.io/en/latest/css-classes-reference.html
        languageList.add(new AbstractMap.SimpleEntry<>("自动判断", "auto"));
        languageList.add(new AbstractMap.SimpleEntry<>("纯文本", "plain"));
        languageList.add(new AbstractMap.SimpleEntry<>("1C", "1c"));
        languageList.add(new AbstractMap.SimpleEntry<>("ABNF", "abnf"));
        languageList.add(new AbstractMap.SimpleEntry<>("Access logs", "accesslog"));
        languageList.add(new AbstractMap.SimpleEntry<>("Ada", "ada"));
        languageList.add(new AbstractMap.SimpleEntry<>("ARM assembler", "armasm"));
        languageList.add(new AbstractMap.SimpleEntry<>("AVR assembler", "avrasm"));
        languageList.add(new AbstractMap.SimpleEntry<>("ActionScript", "actionscript"));
        languageList.add(new AbstractMap.SimpleEntry<>("Apache", "apache"));
        languageList.add(new AbstractMap.SimpleEntry<>("AppleScript", "applescript"));
        languageList.add(new AbstractMap.SimpleEntry<>("AsciiDoc", "asciidoc"));
        languageList.add(new AbstractMap.SimpleEntry<>("AspectJ", "aspectj"));
        languageList.add(new AbstractMap.SimpleEntry<>("AutoHotkey", "autohotkey"));
        languageList.add(new AbstractMap.SimpleEntry<>("AutoIt", "autoit"));
        languageList.add(new AbstractMap.SimpleEntry<>("Awk", "awk"));
        languageList.add(new AbstractMap.SimpleEntry<>("Axapta", "axapta"));
        languageList.add(new AbstractMap.SimpleEntry<>("Bash", "bash"));
        languageList.add(new AbstractMap.SimpleEntry<>("Basic", "basic"));
        languageList.add(new AbstractMap.SimpleEntry<>("BNF", "bnf"));
        languageList.add(new AbstractMap.SimpleEntry<>("Brainfuck", "brainfuck"));
        languageList.add(new AbstractMap.SimpleEntry<>("C#", "cs"));
        languageList.add(new AbstractMap.SimpleEntry<>("C++", "cpp"));
        languageList.add(new AbstractMap.SimpleEntry<>("C/AL", "cal"));
        languageList.add(new AbstractMap.SimpleEntry<>("Cache Object Script", "cos"));
        languageList.add(new AbstractMap.SimpleEntry<>("CMake", "cmake"));
        languageList.add(new AbstractMap.SimpleEntry<>("Coq", "coq"));
        languageList.add(new AbstractMap.SimpleEntry<>("CSP", "csp"));
        languageList.add(new AbstractMap.SimpleEntry<>("CSS", "css"));
        languageList.add(new AbstractMap.SimpleEntry<>("Cap’n Proto", "capnproto"));
        languageList.add(new AbstractMap.SimpleEntry<>("Clojure", "clojure"));
        languageList.add(new AbstractMap.SimpleEntry<>("CoffeeScript", "coffeescript"));
        languageList.add(new AbstractMap.SimpleEntry<>("Crmsh", "crmsh"));
        languageList.add(new AbstractMap.SimpleEntry<>("Crystal", "crystal"));
        languageList.add(new AbstractMap.SimpleEntry<>("D", "d"));
        languageList.add(new AbstractMap.SimpleEntry<>("DNS Zone file", "dns"));
        languageList.add(new AbstractMap.SimpleEntry<>("DOS", "dos"));
        languageList.add(new AbstractMap.SimpleEntry<>("Dart", "dart"));
        languageList.add(new AbstractMap.SimpleEntry<>("Delphi", "delphi"));
        languageList.add(new AbstractMap.SimpleEntry<>("Diff", "diff"));
        languageList.add(new AbstractMap.SimpleEntry<>("Django", "django"));
        languageList.add(new AbstractMap.SimpleEntry<>("Dockerfile", "dockerfile"));
        languageList.add(new AbstractMap.SimpleEntry<>("Dsconfig", "dsconfig"));
        languageList.add(new AbstractMap.SimpleEntry<>("DTS (Device Tree)", "dts"));
        languageList.add(new AbstractMap.SimpleEntry<>("Dust", "dust"));
        languageList.add(new AbstractMap.SimpleEntry<>("EBNF", "ebnf"));
        languageList.add(new AbstractMap.SimpleEntry<>("Elixir", "elixir"));
        languageList.add(new AbstractMap.SimpleEntry<>("Elm", "elm"));
        languageList.add(new AbstractMap.SimpleEntry<>("Erlang", "erlang"));
        languageList.add(new AbstractMap.SimpleEntry<>("Excel", "excel"));
        languageList.add(new AbstractMap.SimpleEntry<>("F#", "fsharp"));
        languageList.add(new AbstractMap.SimpleEntry<>("FIX", "fix"));
        languageList.add(new AbstractMap.SimpleEntry<>("Fortran", "fortran"));
        languageList.add(new AbstractMap.SimpleEntry<>("G-Code", "gcode"));
        languageList.add(new AbstractMap.SimpleEntry<>("Gams", "gams"));
        languageList.add(new AbstractMap.SimpleEntry<>("GAUSS", "gauss"));
        languageList.add(new AbstractMap.SimpleEntry<>("Gherkin", "gherkin"));
        languageList.add(new AbstractMap.SimpleEntry<>("Go", "go"));
        languageList.add(new AbstractMap.SimpleEntry<>("Golo", "golo"));
        languageList.add(new AbstractMap.SimpleEntry<>("Gradle", "gradle"));
        languageList.add(new AbstractMap.SimpleEntry<>("Groovy", "groovy"));
        languageList.add(new AbstractMap.SimpleEntry<>("HTML", "html"));
        languageList.add(new AbstractMap.SimpleEntry<>("HTTP", "http"));
        languageList.add(new AbstractMap.SimpleEntry<>("Haml", "haml"));
        languageList.add(new AbstractMap.SimpleEntry<>("Handlebars", "handlebars"));
        languageList.add(new AbstractMap.SimpleEntry<>("Haskell", "haskell"));
        languageList.add(new AbstractMap.SimpleEntry<>("Haxe", "haxe"));
        languageList.add(new AbstractMap.SimpleEntry<>("Ini", "ini"));
        languageList.add(new AbstractMap.SimpleEntry<>("Inform7", "inform7"));
        languageList.add(new AbstractMap.SimpleEntry<>("IRPF90", "irpf90"));
        languageList.add(new AbstractMap.SimpleEntry<>("JSON", "json"));
        languageList.add(new AbstractMap.SimpleEntry<>("Java", "java"));
        languageList.add(new AbstractMap.SimpleEntry<>("JavaScript", "javascript"));
        languageList.add(new AbstractMap.SimpleEntry<>("Lasso", "lasso"));
        languageList.add(new AbstractMap.SimpleEntry<>("Less", "less"));
        languageList.add(new AbstractMap.SimpleEntry<>("LDIF", "ldif"));
        languageList.add(new AbstractMap.SimpleEntry<>("Lisp", "lisp"));
        languageList.add(new AbstractMap.SimpleEntry<>("LiveCode Server", "livecodeserver"));
        languageList.add(new AbstractMap.SimpleEntry<>("LiveScript", "livescript"));
        languageList.add(new AbstractMap.SimpleEntry<>("Lua", "lua"));
        languageList.add(new AbstractMap.SimpleEntry<>("Makefile", "makefile"));
        languageList.add(new AbstractMap.SimpleEntry<>("Markdown", "markdown"));
        languageList.add(new AbstractMap.SimpleEntry<>("Mathematica", "mathematica"));
        languageList.add(new AbstractMap.SimpleEntry<>("Matlab", "matlab"));
        languageList.add(new AbstractMap.SimpleEntry<>("Maxima", "maxima"));
        languageList.add(new AbstractMap.SimpleEntry<>("Maya Embedded Language", "mel"));
        languageList.add(new AbstractMap.SimpleEntry<>("Mercury", "mercury"));
        languageList.add(new AbstractMap.SimpleEntry<>("Mizar", "mizar"));
        languageList.add(new AbstractMap.SimpleEntry<>("Mojolicious", "mojolicious"));
        languageList.add(new AbstractMap.SimpleEntry<>("Monkey", "monkey"));
        languageList.add(new AbstractMap.SimpleEntry<>("Moonscript", "moonscript"));
        languageList.add(new AbstractMap.SimpleEntry<>("NSIS", "nsis"));
        languageList.add(new AbstractMap.SimpleEntry<>("Nginx", "nginx"));
        languageList.add(new AbstractMap.SimpleEntry<>("Nimrod", "nimrod"));
        languageList.add(new AbstractMap.SimpleEntry<>("Nix", "nix"));
        languageList.add(new AbstractMap.SimpleEntry<>("OCaml", "ocaml"));
        languageList.add(new AbstractMap.SimpleEntry<>("Objective C", "objectivec"));
        languageList.add(new AbstractMap.SimpleEntry<>("OpenGL Shading Language", "glsl"));
        languageList.add(new AbstractMap.SimpleEntry<>("OpenSCAD", "openscad"));
        languageList.add(new AbstractMap.SimpleEntry<>("Oracle Rules Language", "ruleslanguage"));
        languageList.add(new AbstractMap.SimpleEntry<>("Oxygene", "oxygene"));
        languageList.add(new AbstractMap.SimpleEntry<>("PF", "pf"));
        languageList.add(new AbstractMap.SimpleEntry<>("PHP", "php"));
        languageList.add(new AbstractMap.SimpleEntry<>("Parser3", "parser3"));
        languageList.add(new AbstractMap.SimpleEntry<>("Perl", "perl"));
        languageList.add(new AbstractMap.SimpleEntry<>("Pony", "pony"));
        languageList.add(new AbstractMap.SimpleEntry<>("PowerShell", "powershell"));
        languageList.add(new AbstractMap.SimpleEntry<>("Processing", "processing"));
        languageList.add(new AbstractMap.SimpleEntry<>("Prolog", "prolog"));
        languageList.add(new AbstractMap.SimpleEntry<>("Protocol Buffers", "protobuf"));
        languageList.add(new AbstractMap.SimpleEntry<>("Puppet", "puppet"));
        languageList.add(new AbstractMap.SimpleEntry<>("Python", "python"));
        languageList.add(new AbstractMap.SimpleEntry<>("Python profiler results", "profile"));
        languageList.add(new AbstractMap.SimpleEntry<>("Q", "k"));
        languageList.add(new AbstractMap.SimpleEntry<>("QML", "qml"));
        languageList.add(new AbstractMap.SimpleEntry<>("R", "r"));
        languageList.add(new AbstractMap.SimpleEntry<>("RenderMan RIB", "rib"));
        languageList.add(new AbstractMap.SimpleEntry<>("RenderMan RSL", "rsl"));
        languageList.add(new AbstractMap.SimpleEntry<>("Roboconf", "graph"));
        languageList.add(new AbstractMap.SimpleEntry<>("Ruby", "ruby"));
        languageList.add(new AbstractMap.SimpleEntry<>("Rust", "rust"));
        languageList.add(new AbstractMap.SimpleEntry<>("SCSS", "scss"));
        languageList.add(new AbstractMap.SimpleEntry<>("SQL", "sql"));
        languageList.add(new AbstractMap.SimpleEntry<>("STEP Part 21", "p21"));
        languageList.add(new AbstractMap.SimpleEntry<>("Scala", "scala"));
        languageList.add(new AbstractMap.SimpleEntry<>("Scheme", "scheme"));
        languageList.add(new AbstractMap.SimpleEntry<>("Scilab", "scilab"));
        languageList.add(new AbstractMap.SimpleEntry<>("Smali", "smali"));
        languageList.add(new AbstractMap.SimpleEntry<>("Smalltalk", "smalltalk"));
        languageList.add(new AbstractMap.SimpleEntry<>("Stan", "stan"));
        languageList.add(new AbstractMap.SimpleEntry<>("Stata", "stata"));
        languageList.add(new AbstractMap.SimpleEntry<>("Stylus", "stylus"));
        languageList.add(new AbstractMap.SimpleEntry<>("SubUnit", "subunit"));
        languageList.add(new AbstractMap.SimpleEntry<>("Swift", "swift"));
        languageList.add(new AbstractMap.SimpleEntry<>("Test Anything Protocol", "tap"));
        languageList.add(new AbstractMap.SimpleEntry<>("Tcl", "tcl"));
        languageList.add(new AbstractMap.SimpleEntry<>("TeX", "tex"));
        languageList.add(new AbstractMap.SimpleEntry<>("Thrift", "thrift"));
        languageList.add(new AbstractMap.SimpleEntry<>("TP", "tp"));
        languageList.add(new AbstractMap.SimpleEntry<>("Twig", "twig"));
        languageList.add(new AbstractMap.SimpleEntry<>("TypeScript", "typescript"));
        languageList.add(new AbstractMap.SimpleEntry<>("VB.Net", "vbnet"));
        languageList.add(new AbstractMap.SimpleEntry<>("VBScript", "vbscript"));
        languageList.add(new AbstractMap.SimpleEntry<>("VHDL", "vhdl"));
        languageList.add(new AbstractMap.SimpleEntry<>("Vala", "vala"));
        languageList.add(new AbstractMap.SimpleEntry<>("Verilog", "verilog"));
        languageList.add(new AbstractMap.SimpleEntry<>("Vim Script", "vim"));
        languageList.add(new AbstractMap.SimpleEntry<>("x86 Assembly", "x86asm"));
        languageList.add(new AbstractMap.SimpleEntry<>("XL", "xl"));
        languageList.add(new AbstractMap.SimpleEntry<>("XML", "html"));
        languageList.add(new AbstractMap.SimpleEntry<>("XQuery", "xpath"));
        languageList.add(new AbstractMap.SimpleEntry<>("Zephir", "zephir"));

        languageMap = new HashMap<>(languageList.size());
        for(Map.Entry<String, String> it : languageList)
            languageMap.put(it.getKey(), it.getValue());
    }

    public List<Map.Entry<String, String>> getLanguageList() {
        return languageList;
    }

    public boolean exsits(String languageId) {
        return languageMap.containsKey(languageId);
    }
}
