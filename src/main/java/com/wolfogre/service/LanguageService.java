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
        // TODO：从http://paste.ubuntu.com/上抄的，但是有些不规整
        languageList.add(new AbstractMap.SimpleEntry<>("text", "纯文本"));
        languageList.add(new AbstractMap.SimpleEntry<>("Cucumber", "Gherkin"));
        languageList.add(new AbstractMap.SimpleEntry<>("abap", "ABAP"));
        languageList.add(new AbstractMap.SimpleEntry<>("ada", "Ada"));
        languageList.add(new AbstractMap.SimpleEntry<>("ahk", "autohotkey"));
        languageList.add(new AbstractMap.SimpleEntry<>("antlr", "ANTLR"));
        languageList.add(new AbstractMap.SimpleEntry<>("antlr-as", "ANTLR With ActionScript Target"));
        languageList.add(new AbstractMap.SimpleEntry<>("antlr-cpp", "ANTLR With CPP Target"));
        languageList.add(new AbstractMap.SimpleEntry<>("antlr-csharp", "ANTLR With C# Target"));
        languageList.add(new AbstractMap.SimpleEntry<>("antlr-java", "ANTLR With Java Target"));
        languageList.add(new AbstractMap.SimpleEntry<>("antlr-objc", "ANTLR With ObjectiveC Target"));
        languageList.add(new AbstractMap.SimpleEntry<>("antlr-perl", "ANTLR With Perl Target"));
        languageList.add(new AbstractMap.SimpleEntry<>("antlr-python", "ANTLR With Python Target"));
        languageList.add(new AbstractMap.SimpleEntry<>("antlr-ruby", "ANTLR With Ruby Target"));
        languageList.add(new AbstractMap.SimpleEntry<>("apacheconf", "ApacheConf"));
        languageList.add(new AbstractMap.SimpleEntry<>("applescript", "AppleScript"));
        languageList.add(new AbstractMap.SimpleEntry<>("as", "ActionScript"));
        languageList.add(new AbstractMap.SimpleEntry<>("as3", "ActionScript 3"));
        languageList.add(new AbstractMap.SimpleEntry<>("aspx-cs", "aspx-cs"));
        languageList.add(new AbstractMap.SimpleEntry<>("aspx-vb", "aspx-vb"));
        languageList.add(new AbstractMap.SimpleEntry<>("asy", "Asymptote"));
        languageList.add(new AbstractMap.SimpleEntry<>("basemake", "Makefile"));
        languageList.add(new AbstractMap.SimpleEntry<>("bash", "Bash"));
        languageList.add(new AbstractMap.SimpleEntry<>("bat", "Batchfile"));
        languageList.add(new AbstractMap.SimpleEntry<>("bbcode", "BBCode"));
        languageList.add(new AbstractMap.SimpleEntry<>("befunge", "Befunge"));
        languageList.add(new AbstractMap.SimpleEntry<>("blitzmax", "BlitzMax"));
        languageList.add(new AbstractMap.SimpleEntry<>("boo", "Boo"));
        languageList.add(new AbstractMap.SimpleEntry<>("c", "C"));
        languageList.add(new AbstractMap.SimpleEntry<>("c-objdump", "c-objdump"));
        languageList.add(new AbstractMap.SimpleEntry<>("cfm", "Coldfusion HTML"));
        languageList.add(new AbstractMap.SimpleEntry<>("cfs", "cfstatement"));
        languageList.add(new AbstractMap.SimpleEntry<>("cheetah", "Cheetah"));
        languageList.add(new AbstractMap.SimpleEntry<>("clojure", "Clojure"));
        languageList.add(new AbstractMap.SimpleEntry<>("cmake", "CMake"));
        languageList.add(new AbstractMap.SimpleEntry<>("coffee-script", "CoffeeScript"));
        languageList.add(new AbstractMap.SimpleEntry<>("common-lisp", "Common Lisp"));
        languageList.add(new AbstractMap.SimpleEntry<>("console", "Bash Session"));
        languageList.add(new AbstractMap.SimpleEntry<>("control", "Debian Control file"));
        languageList.add(new AbstractMap.SimpleEntry<>("cpp", "C++"));
        languageList.add(new AbstractMap.SimpleEntry<>("cpp-objdump", "cpp-objdump"));
        languageList.add(new AbstractMap.SimpleEntry<>("csharp", "C#"));
        languageList.add(new AbstractMap.SimpleEntry<>("css", "CSS"));
        languageList.add(new AbstractMap.SimpleEntry<>("css+django", "CSS+Django/Jinja"));
        languageList.add(new AbstractMap.SimpleEntry<>("css+erb", "CSS+Ruby"));
        languageList.add(new AbstractMap.SimpleEntry<>("css+genshitext", "CSS+Genshi Text"));
        languageList.add(new AbstractMap.SimpleEntry<>("css+mako", "CSS+Mako"));
        languageList.add(new AbstractMap.SimpleEntry<>("css+myghty", "CSS+Myghty"));
        languageList.add(new AbstractMap.SimpleEntry<>("css+php", "CSS+PHP"));
        languageList.add(new AbstractMap.SimpleEntry<>("css+smarty", "CSS+Smarty"));
        languageList.add(new AbstractMap.SimpleEntry<>("cython", "Cython"));
        languageList.add(new AbstractMap.SimpleEntry<>("d", "D"));
        languageList.add(new AbstractMap.SimpleEntry<>("d-objdump", "d-objdump"));
        languageList.add(new AbstractMap.SimpleEntry<>("delphi", "Delphi"));
        languageList.add(new AbstractMap.SimpleEntry<>("diff", "Diff"));
        languageList.add(new AbstractMap.SimpleEntry<>("django", "Django/Jinja"));
        languageList.add(new AbstractMap.SimpleEntry<>("dpatch", "Darcs Patch"));
        languageList.add(new AbstractMap.SimpleEntry<>("duel", "Duel"));
        languageList.add(new AbstractMap.SimpleEntry<>("dylan", "Dylan"));
        languageList.add(new AbstractMap.SimpleEntry<>("erb", "ERB"));
        languageList.add(new AbstractMap.SimpleEntry<>("erl", "Erlang erl session"));
        languageList.add(new AbstractMap.SimpleEntry<>("erlang", "Erlang"));
        languageList.add(new AbstractMap.SimpleEntry<>("evoque", "Evoque"));
        languageList.add(new AbstractMap.SimpleEntry<>("factor", "Factor"));
        languageList.add(new AbstractMap.SimpleEntry<>("felix", "Felix"));
        languageList.add(new AbstractMap.SimpleEntry<>("fortran", "Fortran"));
        languageList.add(new AbstractMap.SimpleEntry<>("gas", "GAS"));
        languageList.add(new AbstractMap.SimpleEntry<>("genshi", "Genshi"));
        languageList.add(new AbstractMap.SimpleEntry<>("genshitext", "Genshi Text"));
        languageList.add(new AbstractMap.SimpleEntry<>("glsl", "GLSL"));
        languageList.add(new AbstractMap.SimpleEntry<>("gnuplot", "Gnuplot"));
        languageList.add(new AbstractMap.SimpleEntry<>("go", "Go"));
        languageList.add(new AbstractMap.SimpleEntry<>("gooddata-cl", "GoodData-CL"));
        languageList.add(new AbstractMap.SimpleEntry<>("groff", "Groff"));
        languageList.add(new AbstractMap.SimpleEntry<>("haml", "Haml"));
        languageList.add(new AbstractMap.SimpleEntry<>("haskell", "Haskell"));
        languageList.add(new AbstractMap.SimpleEntry<>("html", "HTML"));
        languageList.add(new AbstractMap.SimpleEntry<>("html+cheetah", "HTML+Cheetah"));
        languageList.add(new AbstractMap.SimpleEntry<>("html+django", "HTML+Django/Jinja"));
        languageList.add(new AbstractMap.SimpleEntry<>("html+evoque", "HTML+Evoque"));
        languageList.add(new AbstractMap.SimpleEntry<>("html+genshi", "HTML+Genshi"));
        languageList.add(new AbstractMap.SimpleEntry<>("html+mako", "HTML+Mako"));
        languageList.add(new AbstractMap.SimpleEntry<>("html+myghty", "HTML+Myghty"));
        languageList.add(new AbstractMap.SimpleEntry<>("html+php", "HTML+PHP"));
        languageList.add(new AbstractMap.SimpleEntry<>("html+smarty", "HTML+Smarty"));
        languageList.add(new AbstractMap.SimpleEntry<>("html+velocity", "HTML+Velocity"));
        languageList.add(new AbstractMap.SimpleEntry<>("hx", "haXe"));
        languageList.add(new AbstractMap.SimpleEntry<>("hybris", "Hybris"));
        languageList.add(new AbstractMap.SimpleEntry<>("ini", "INI"));
        languageList.add(new AbstractMap.SimpleEntry<>("io", "Io"));
        languageList.add(new AbstractMap.SimpleEntry<>("ioke", "Ioke"));
        languageList.add(new AbstractMap.SimpleEntry<>("irc", "IRC logs"));
        languageList.add(new AbstractMap.SimpleEntry<>("jade", "Jade"));
        languageList.add(new AbstractMap.SimpleEntry<>("java", "Java"));
        languageList.add(new AbstractMap.SimpleEntry<>("js", "JavaScript"));
        languageList.add(new AbstractMap.SimpleEntry<>("js+cheetah", "JavaScript+Cheetah"));
        languageList.add(new AbstractMap.SimpleEntry<>("js+django", "JavaScript+Django/Jinja"));
        languageList.add(new AbstractMap.SimpleEntry<>("js+erb", "JavaScript+Ruby"));
        languageList.add(new AbstractMap.SimpleEntry<>("js+genshitext", "JavaScript+Genshi Text"));
        languageList.add(new AbstractMap.SimpleEntry<>("js+mako", "JavaScript+Mako"));
        languageList.add(new AbstractMap.SimpleEntry<>("js+myghty", "JavaScript+Myghty"));
        languageList.add(new AbstractMap.SimpleEntry<>("js+php", "JavaScript+PHP"));
        languageList.add(new AbstractMap.SimpleEntry<>("js+smarty", "JavaScript+Smarty"));
        languageList.add(new AbstractMap.SimpleEntry<>("jsp", "Java Server Page"));
        languageList.add(new AbstractMap.SimpleEntry<>("lhs", "Literate Haskell"));
        languageList.add(new AbstractMap.SimpleEntry<>("lighty", "Lighttpd configuration file"));
        languageList.add(new AbstractMap.SimpleEntry<>("llvm", "LLVM"));
        languageList.add(new AbstractMap.SimpleEntry<>("logtalk", "Logtalk"));
        languageList.add(new AbstractMap.SimpleEntry<>("lua", "Lua"));
        languageList.add(new AbstractMap.SimpleEntry<>("make", "Makefile"));
        languageList.add(new AbstractMap.SimpleEntry<>("mako", "Mako"));
        languageList.add(new AbstractMap.SimpleEntry<>("maql", "MAQL"));
        languageList.add(new AbstractMap.SimpleEntry<>("mason", "Mason"));
        languageList.add(new AbstractMap.SimpleEntry<>("matlab", "Matlab"));
        languageList.add(new AbstractMap.SimpleEntry<>("matlabsession", "Matlab session"));
        languageList.add(new AbstractMap.SimpleEntry<>("minid", "MiniD"));
        languageList.add(new AbstractMap.SimpleEntry<>("modelica", "Modelica"));
        languageList.add(new AbstractMap.SimpleEntry<>("modula2", "Modula-2"));
        languageList.add(new AbstractMap.SimpleEntry<>("moocode", "MOOCode"));
        languageList.add(new AbstractMap.SimpleEntry<>("mupad", "MuPAD"));
        languageList.add(new AbstractMap.SimpleEntry<>("mxml", "MXML"));
        languageList.add(new AbstractMap.SimpleEntry<>("myghty", "Myghty"));
        languageList.add(new AbstractMap.SimpleEntry<>("mysql", "MySQL"));
        languageList.add(new AbstractMap.SimpleEntry<>("nasm", "NASM"));
        languageList.add(new AbstractMap.SimpleEntry<>("newspeak", "Newspeak"));
        languageList.add(new AbstractMap.SimpleEntry<>("nginx", "Nginx configuration file"));
        languageList.add(new AbstractMap.SimpleEntry<>("numpy", "NumPy"));
        languageList.add(new AbstractMap.SimpleEntry<>("objdump", "objdump"));
        languageList.add(new AbstractMap.SimpleEntry<>("objective-c", "Objective-C"));
        languageList.add(new AbstractMap.SimpleEntry<>("objective-j", "Objective-J"));
        languageList.add(new AbstractMap.SimpleEntry<>("ocaml", "OCaml"));
        languageList.add(new AbstractMap.SimpleEntry<>("ooc", "Ooc"));
        languageList.add(new AbstractMap.SimpleEntry<>("perl", "Perl"));
        languageList.add(new AbstractMap.SimpleEntry<>("php", "PHP"));
        languageList.add(new AbstractMap.SimpleEntry<>("postscript", "PostScript"));
        languageList.add(new AbstractMap.SimpleEntry<>("pot", "Gettext Catalog"));
        languageList.add(new AbstractMap.SimpleEntry<>("pov", "POVRay"));
        languageList.add(new AbstractMap.SimpleEntry<>("prolog", "Prolog"));
        languageList.add(new AbstractMap.SimpleEntry<>("properties", "Properties"));
        languageList.add(new AbstractMap.SimpleEntry<>("protobuf", "Protocol Buffer"));
        languageList.add(new AbstractMap.SimpleEntry<>("py3tb", "Python 3.0 Traceback"));
        languageList.add(new AbstractMap.SimpleEntry<>("pycon", "Python console session"));
        languageList.add(new AbstractMap.SimpleEntry<>("pytb", "Python Traceback"));
        languageList.add(new AbstractMap.SimpleEntry<>("python", "Python"));
        languageList.add(new AbstractMap.SimpleEntry<>("python3", "Python 3"));
        languageList.add(new AbstractMap.SimpleEntry<>("ragel", "Ragel"));
        languageList.add(new AbstractMap.SimpleEntry<>("ragel-c", "Ragel in C Host"));
        languageList.add(new AbstractMap.SimpleEntry<>("ragel-cpp", "Ragel in CPP Host"));
        languageList.add(new AbstractMap.SimpleEntry<>("ragel-d", "Ragel in D Host"));
        languageList.add(new AbstractMap.SimpleEntry<>("ragel-em", "Embedded Ragel"));
        languageList.add(new AbstractMap.SimpleEntry<>("ragel-java", "Ragel in Java Host"));
        languageList.add(new AbstractMap.SimpleEntry<>("ragel-objc", "Ragel in Objective C Host"));
        languageList.add(new AbstractMap.SimpleEntry<>("ragel-ruby", "Ragel in Ruby Host"));
        languageList.add(new AbstractMap.SimpleEntry<>("raw", "Raw token data"));
        languageList.add(new AbstractMap.SimpleEntry<>("rb", "Ruby"));
        languageList.add(new AbstractMap.SimpleEntry<>("rbcon", "Ruby irb session"));
        languageList.add(new AbstractMap.SimpleEntry<>("rconsole", "RConsole"));
        languageList.add(new AbstractMap.SimpleEntry<>("rebol", "REBOL"));
        languageList.add(new AbstractMap.SimpleEntry<>("redcode", "Redcode"));
        languageList.add(new AbstractMap.SimpleEntry<>("rhtml", "RHTML"));
        languageList.add(new AbstractMap.SimpleEntry<>("rst", "reStructuredText"));
        languageList.add(new AbstractMap.SimpleEntry<>("sass", "Sass"));
        languageList.add(new AbstractMap.SimpleEntry<>("scala", "Scala"));
        languageList.add(new AbstractMap.SimpleEntry<>("scaml", "Scaml"));
        languageList.add(new AbstractMap.SimpleEntry<>("scheme", "Scheme"));
        languageList.add(new AbstractMap.SimpleEntry<>("scss", "SCSS"));
        languageList.add(new AbstractMap.SimpleEntry<>("smalltalk", "Smalltalk"));
        languageList.add(new AbstractMap.SimpleEntry<>("smarty", "Smarty"));
        languageList.add(new AbstractMap.SimpleEntry<>("sourceslist", "Debian Sourcelist"));
        languageList.add(new AbstractMap.SimpleEntry<>("splus", "S"));
        languageList.add(new AbstractMap.SimpleEntry<>("sql", "SQL"));
        languageList.add(new AbstractMap.SimpleEntry<>("sqlite3", "sqlite3con"));
        languageList.add(new AbstractMap.SimpleEntry<>("squidconf", "SquidConf"));
        languageList.add(new AbstractMap.SimpleEntry<>("ssp", "Scalate Server Page"));
        languageList.add(new AbstractMap.SimpleEntry<>("tcl", "Tcl"));
        languageList.add(new AbstractMap.SimpleEntry<>("tcsh", "Tcsh"));
        languageList.add(new AbstractMap.SimpleEntry<>("tex", "TeX"));
        languageList.add(new AbstractMap.SimpleEntry<>("text", "Text only"));
        languageList.add(new AbstractMap.SimpleEntry<>("trac-wiki", "MoinMoin/Trac Wiki markup"));
        languageList.add(new AbstractMap.SimpleEntry<>("v", "verilog"));
        languageList.add(new AbstractMap.SimpleEntry<>("vala", "Vala"));
        languageList.add(new AbstractMap.SimpleEntry<>("vb.net", "VB.net"));
        languageList.add(new AbstractMap.SimpleEntry<>("velocity", "Velocity"));
        languageList.add(new AbstractMap.SimpleEntry<>("vim", "VimL"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml", "XML"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml+cheetah", "XML+Cheetah"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml+django", "XML+Django/Jinja"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml+erb", "XML+Ruby"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml+evoque", "XML+Evoque"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml+mako", "XML+Mako"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml+myghty", "XML+Myghty"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml+php", "XML+PHP"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml+smarty", "XML+Smarty"));
        languageList.add(new AbstractMap.SimpleEntry<>("xml+velocity", "XML+Velocity"));
        languageList.add(new AbstractMap.SimpleEntry<>("xquery", "XQuery"));
        languageList.add(new AbstractMap.SimpleEntry<>("xslt", "XSLT"));
        languageList.add(new AbstractMap.SimpleEntry<>("yaml", "YAML"));

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
