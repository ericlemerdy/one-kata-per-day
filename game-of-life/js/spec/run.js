import Jasmine from 'jasmine'
import SpecReporter from 'jasmine-spec-reporter'

const jasmine = new Jasmine()
jasmine.env.clearReporters()
jasmine.addReporter(new SpecReporter())
jasmine.loadConfigFile('spec/support/jasmine.json')
jasmine.execute()